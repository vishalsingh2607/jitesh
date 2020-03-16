package com.mobileprogramming.ats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mobileprogramming.ats.model.Candidate;

@Service
public interface CandidateService {
	// Get All Candidates
	public List<Candidate> getAllCandidiates();

	// Get Candidate By Id
	public Optional<Candidate> getCandidate(Integer id);

	// Create
	public String saveCandidate(Candidate candidate);

	// Update
	public String updateCandidate(Integer id, Candidate candidate);

	// Delete
	public String deleteCandidate(Integer id);
	
   //Fetching Candidate Details Pagewise
	public Page<Candidate> findAllByPage(Pageable pageable);


	

	
}
