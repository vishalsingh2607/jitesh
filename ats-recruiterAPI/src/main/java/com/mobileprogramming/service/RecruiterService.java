package com.mobileprogramming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.Recruiter;

@Service
public interface RecruiterService {
	
	// Get All Recruiters
	public List<Recruiter> getAllRecruiters();

	// Get Recruiter By Id
	public Optional<Recruiter> getRecruiter(Integer id);

	// Create
	public Recruiter saveRecruiter(Recruiter recruiter);

	// Update
	public String updateRecruiter(Integer id, Recruiter recruiter);
	
	//Optional<Recruiter> findByEmail(String email);
	// Delete
	public String deleteRecruiter(Integer id);
	
   //Fetching Candidate Details Pagewise
	public Page<Recruiter> findAllByPage(Pageable pageable);

	Optional<Recruiter> findByEmailAndPassword(String email, String pwd);

	

}
