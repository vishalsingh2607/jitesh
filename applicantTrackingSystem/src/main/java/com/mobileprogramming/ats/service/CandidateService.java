package com.mobileprogramming.ats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import com.mobileprogramming.ats.model.Candidate;

public interface CandidateService {
	// Get All Candidates
	public List<Candidate> getAllCandidiates();

	// Get Candidate By Id
	public Optional<Candidate> getCandidate(Integer id);

	// Create
	public void saveCandidate(Candidate candidate);

	// Update
	public void updateCandidate(Integer id, Candidate candidate);

	// Delete
	public void deleteCandidate(Integer id);
	
   //Fetching Candidate Details Pagewise
	public Page<Candidate> findAllByPage(Pageable pageable);


	

	
}
