package com.bolsadeideas.springboot.backend.apirest.controllers;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Region;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClienteService;
import com.bolsadeideas.springboot.backend.apirest.models.services.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("api/clientes")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping
	public List<Cliente> index() {
		return clienteService.findAll();
	}

	@GetMapping("page/{page}")
	public Page<Cliente> index(@PathVariable Integer page) {
		return clienteService.findAll(PageRequest.of(page, 4));
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping("regions")
	public List<Region> listRegions() {
		return clienteService.obtainRegions();
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Map<String, String> response = new HashMap<>();
		Cliente cliente = null;
		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("Message", "Internal Error Exception");
			response.put("Error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cliente == null) {
			response.put("Message", "Customer Not Found -> ".concat(String.valueOf(id)));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(clienteService.findById(id));
	}

	@Secured({"ROLE_ADMIN"})
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();
		Cliente customer = null;

		if (bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(err -> "The field '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("Error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			customer = clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put("Message", "Internal Error Exception");
			response.put("Error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("Message", "Customer has been created");
		response.put("Customer", customer);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({"ROLE_ADMIN"})
	@PutMapping("{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult bindingResult,
			@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Cliente clienteActual = clienteService.findById(id);

		if (bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(err -> "The field '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("Error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (clienteActual == null) {
			response.put("Error", "Customer Not Found -> ".concat(String.valueOf(id)));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		Cliente clienteUpdate = null;
		try {
			clienteActual.setName(cliente.getName());
			clienteActual.setLastName(cliente.getLastName());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setCreateAt(cliente.getCreateAt());
			clienteActual.setRegion(cliente.getRegion());
			clienteUpdate = clienteService.save(clienteActual);
		} catch (DataAccessException e) {
			response.put("Message", "Internal Error Exception");
			response.put("Error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Message", "Customer has been updated");
		response.put("Customer", clienteUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Cliente cliente = clienteService.findById(id);
			uploadFileService.delete(cliente.getPicture());
			clienteService.delete(id);
		} catch (DataAccessException e) {
			response.put("Message", "Internal Error Exception");
			response.put("Error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Message", "Customer has been deleted");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@PostMapping("upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		Cliente cliente = clienteService.findById(id);
		if (!file.isEmpty()) {
			String fileName = null;
			try {
				fileName = uploadFileService.copy(file);
			} catch (IOException e) {
				response.put("Message", "Internal Error Exception");
				response.put("Error", e.getMessage().concat(" : ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			uploadFileService.delete(cliente.getPicture());
			cliente.setPicture(fileName);
			clienteService.save(cliente);
			response.put("Message", "Successfully uploaded! " + fileName);
			response.put("Customer", cliente);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("uploads/img/{photoName:.+}")
	public ResponseEntity<Resource> showPhoto(@PathVariable String photoName) {
		Resource resource = null;
		try {
			resource = uploadFileService.uploadImage(photoName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpHeaders header = new HttpHeaders();
		if(resource != null) {
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
		}

		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}

}
