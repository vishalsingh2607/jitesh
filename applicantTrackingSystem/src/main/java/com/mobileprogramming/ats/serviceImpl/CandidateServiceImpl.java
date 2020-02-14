package com.mobileprogramming.ats.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	// Get All Candidates list page wise
	@Override
	public List<Candidate> getAllCandidiates() {

		return candidateRepository.findAll();

	}

	// Fetching Candidate Details Pagewise
	@Override
	public Page<Candidate> findAllByPage(Pageable pageable) {

		return candidateRepository.findAll(pageable);
	}

	// Get Candidate By Id
	public Optional<Candidate> getCandidate(Integer id) {
		return candidateRepository.findById(id);

	}

	// Create
	public void saveCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	// Update
	public void updateCandidate(Integer id, Candidate candidate) {
		candidateRepository.save(candidate);
	}

	// Delete
	public void deleteCandidate(Integer id) {
		candidateRepository.deleteById(id);
	}

}
