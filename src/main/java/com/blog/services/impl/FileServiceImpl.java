package com.blog.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// extract file name
		String name = file.getOriginalFilename();
		// generate random name
		String randomId = UUID.randomUUID().toString();
		String newFileName = randomId + name;
		// create full path till file
		String filePath = path + File.separator + newFileName;
		// create images/ folder if not present
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}
		// file copy to full path
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + File.separator + fileName;
		InputStream is = new FileInputStream(fullPath);
		// db logic to get inputstream
		return is;
	}

}
