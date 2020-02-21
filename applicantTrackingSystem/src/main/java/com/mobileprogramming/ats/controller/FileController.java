package com.mobileprogramming.ats.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobileprogramming.ats.model.UploadFiles;
import com.mobileprogramming.ats.serviceImpl.FileStorageService;


@RestController
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/uploadFile")
	public UploadFiles uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		return fileStorageService.storeFile(file);
	}
}
