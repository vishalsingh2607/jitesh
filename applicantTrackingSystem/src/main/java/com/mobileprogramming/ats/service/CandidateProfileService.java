package com.mobileprogramming.ats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.mobileprogramming.ats.dto.CandidateProfileDetailsDto;
import com.mobileprogramming.ats.model.Candidate;

public interface CandidateProfileService {

	// Create
	public String saveCandidateProfile(Candidate candidate, MultipartFile file);

	// Update
	public String updateCandidateProfile(Long id, Candidate candidate,MultipartFile file);

	// Delete
	public String deleteCandidate(Long id);

	// Fetching Candidate Details Pagewise
	public Page<Candidate> findAllByPage(Pageable pageable);

	// Get candidate profiles
	public List<CandidateProfileDetailsDto> getCandidateProfiles();

	public Optional<Candidate> getCandidateById(Long id);

	// Generating Report
	// public List<Candidate> generateRepo();

}
