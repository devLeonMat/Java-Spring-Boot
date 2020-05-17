package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	private final static String UPLOAD_SOURCE = "uploads";

	private final Logger logger = LoggerFactory.getLogger(UploadFileServiceImpl.class);

	@Override
	public Resource uploadImage(String fileName) throws MalformedURLException {
		Path pathFile = getPath(fileName);
		Resource resource = new UrlResource(pathFile.toUri());
		if (!resource.exists() && !resource.isReadable()) {
			pathFile = Paths.get("src/main/resources/static/images").resolve("user-unknown.png").toAbsolutePath();
			resource = new UrlResource(pathFile.toUri());
			logger.error("Couldn't load image! " + fileName);
		}
		return resource;
	}

	@Override
	public String copy(MultipartFile multipartFile) throws IOException {
		String fileName = String.valueOf(UUID.randomUUID()) + "_"
				+ multipartFile.getOriginalFilename().replace(" ", "");
		Path pathFile = getPath(fileName);
		logger.info(String.valueOf(pathFile));
		Files.copy(multipartFile.getInputStream(), pathFile);
		return fileName;
	}

	@Override
	public boolean delete(String fileName) {
		if (fileName != null && fileName.length() > 0) {
			Path pathPhotoSaved = getPath(fileName);
			File filePhotoSaved = pathPhotoSaved.toFile();
			if (filePhotoSaved.exists() && filePhotoSaved.canRead()) {
				filePhotoSaved.delete();
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Path getPath(String fileName) {
		return Paths.get(UPLOAD_SOURCE).resolve(fileName).toAbsolutePath();
	}

}
