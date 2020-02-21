package com.mobileprogramming.ats.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mobileprogramming.ats.dao.FilesRepository;
import com.mobileprogramming.ats.exception.FileStorageException;
import com.mobileprogramming.ats.fileproperty.FileStorageProperties;
import com.mobileprogramming.ats.model.UploadFiles;

@Service
public class FileStorageService {
	
	@Autowired
	private FilesRepository filesRespository;
	
	private final Path fileStorageLocation;
	
	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
	  this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
	
	  try {
		  Files.createDirectories(this.fileStorageLocation);
	  }catch(Exception ex) {
		  throw new FileStorageException("Could not create the directory where the uploaded");
	  }
	}
	


	public UploadFiles storeFile(MultipartFile file) {
		// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
         String fileNo = UUID.randomUUID().toString();
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }


            // Copy file to the target location (Replacing existing file with the same name)
             Path targetLocation = this.fileStorageLocation.resolve(fileNo+fileName);
             Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
             
             
            UploadFiles dbfil= new UploadFiles(fileNo+fileName, fileStorageLocation+"\\"+fileNo+file.getOriginalFilename(), file.getContentType(),file.getSize());
            return filesRespository.save(dbfil);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    
	}
	
	
	
	
	
	
	
}
