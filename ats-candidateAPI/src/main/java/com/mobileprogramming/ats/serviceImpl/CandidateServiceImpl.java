package com.mobileprogramming.ats.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.repository.CandidateRepository;
import com.mobileprogramming.ats.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public List<Candidate> getAllCandidiates() {
		// TODO Auto-generated method stub
		return candidateRepository.findAll();
	}

	@Override
	public Optional<Candidate> getCandidate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		candidateRepository.save(candidate);
		return "Record Saved";
	}

	@Override
	public String updateCandidate(Integer id, Candidate candidate) {
		// TODO Auto-generated method stub
		candidateRepository.save(candidate);
		return "Record Updated";
	}

	@Override
	public String deleteCandidate(Integer id) {
		candidateRepository.deleteById(id);
		return "Record Deleted";
		
	}

	@Override
	public Page<Candidate> findAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



}
