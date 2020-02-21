package com.mobileprogramming.ats.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.model.UploadFiles;
import com.mobileprogramming.ats.serviceImpl.FileStorageService;


@RestController("/fileapi")
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/fileapi/uploadFile")
	public ResponseEntity<UploadFiles>  uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		 fileStorageService.storeFile(file);
		 return new ResponseEntity<UploadFiles>( fileStorageService.storeFile(file),HttpStatus.ACCEPTED);
	}
}
