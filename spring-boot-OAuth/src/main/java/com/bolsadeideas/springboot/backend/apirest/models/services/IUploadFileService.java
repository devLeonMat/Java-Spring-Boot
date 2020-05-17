package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Resource uploadImage(String fileName) throws MalformedURLException;
	
	public String copy(MultipartFile multipartFile) throws IOException;
	
	public boolean delete(String fileName);
	
	public Path getPath(String fileName);

}
