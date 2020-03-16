package com.mobileprogramming.ats.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.dto.CandidateProfileDetailsDto;
import com.mobileprogramming.ats.exception.FileStorageException;
import com.mobileprogramming.ats.fileproperty.FileStorageProperties;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.CandidateProfileService;
import com.mobileprogramming.ats.service.ConverterService;

@Service
public class CandidateProfileServiceImpl implements CandidateProfileService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private ConverterService converterservice;

	private Path fileStorageLocation;

	@Autowired
	public void FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded");
		}
	}

	// Get candidate profiles
	@Override
	public List<CandidateProfileDetailsDto> getCandidateProfiles() {

		return candidateRepository.findAll().stream().map(converterservice::convertToCandidatePersonalDetailsDto)
				.collect(Collectors.toList());

	}

	// Fetching Candidate Details Pagewise
	@Override
	public Page<Candidate> findAllByPage(Pageable pageable) {

		return candidateRepository.findAll(pageable);
	}

	// Create
	public String saveCandidateProfile(Candidate candidate, MultipartFile file) {

		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String fileNo = UUID.randomUUID().toString();
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileNo + fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			candidate.setResumestoragepath(fileStorageLocation + "\\" + fileNo + file.getOriginalFilename());

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		candidate.setCandidateProfileCreatedAt(date);
		candidateRepository.save(candidate);
		return "succesfully added a candidate";

	}

	// Update
	@Override
	public String updateCandidateProfile(Long id, Candidate candidate, MultipartFile file) {

		File oldfile = new File(candidateRepository.findById(id).get().getResumestoragepath());
		oldfile.delete();

		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String fileNo = UUID.randomUUID().toString();
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileNo + fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			candidate.setResumestoragepath(fileStorageLocation + "\\" + fileNo + file.getOriginalFilename());

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}

		if (candidate.getCandidatename() == null || candidate.getFathername() == null || candidate.getDob() == null
				|| candidate.getEmailid() == null || candidate.getContactno() == null
				|| candidate.getTechnology() == null || candidate.getLocation() == null
				|| candidate.getDesignation() == null || candidate.getTotalexperience() == 0
				|| candidate.getCurrentsalaryinlpa() == 0 || candidate.getExpectedsalaryinlpa() == 0
				|| candidate.getNoticeperiodindays() == 0 || candidate.getRecruiterid() == null
				|| candidate.getRecruitername() == null || candidate.getResumestoragepath() == null
				|| candidate.getOfferstatus() == null) {
			return "Please enter all the required fields";
		} else {

			candidateRepository.findById(id).map(newcandidate -> {
				newcandidate.setCandidatename(candidate.getCandidatename());
				newcandidate.setFathername(candidate.getFathername());
				newcandidate.setDob(candidate.getDob());
				newcandidate.setEmailid(candidate.getEmailid());
				newcandidate.setContactno(candidate.getContactno());
				newcandidate.setTechnology(candidate.getTechnology());
				newcandidate.setLocation(candidate.getLocation());
				newcandidate.setDesignation(candidate.getDesignation());
				newcandidate.setTotalexperience(candidate.getTotalexperience());
				newcandidate.setCurrentsalaryinlpa(candidate.getCurrentsalaryinlpa());
				newcandidate.setExpectedsalaryinlpa(candidate.getExpectedsalaryinlpa());
				newcandidate.setNoticeperiodindays(candidate.getNoticeperiodindays());
				newcandidate.setRecruiterid(candidate.getRecruiterid());
				newcandidate.setRecruitername(candidate.getRecruitername());
				newcandidate.setResumestoragepath(candidate.getResumestoragepath());
				newcandidate.setOfferstatus(candidate.getOfferstatus());
				java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
				newcandidate.setCandidateProfileUpdatedAt(date);
				return candidateRepository.save(newcandidate);

			});

			return "Candidate details updated successfully";
		}

	}

	// Delete
	public String deleteCandidate(Long id) {
		candidateRepository.deleteById(id);
		return "Candidate deleted successfully";
	}

	// Get Candidate By Id
	@Override
	public Optional<Candidate> getCandidateById(Long id) {

		return candidateRepository.findById(id);

	}

	/*
	 * @Override public List<Candidate> generateRepo() { return
	 * candidateRepository.finObjects(); }
	 */

}
