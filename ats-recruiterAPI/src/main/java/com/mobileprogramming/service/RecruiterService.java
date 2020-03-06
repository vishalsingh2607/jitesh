package com.mobileprogramming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.Recruiter;

@Service
public interface RecruiterService {
	
	
	public List<Recruiter> getAllRecruiters();

	public Optional<Recruiter> getRecruiter(Integer id);

    public Recruiter saveRecruiter(Recruiter recruiter);

	public String updateRecruiter(Integer id, Recruiter recruiter);
	
	public String deleteRecruiter(Integer id);
	
    public Page<Recruiter> findAllByPage(Pageable pageable);

	Optional<Recruiter> findByEmailAndPassword(String email, String pwd);

	Optional<Recruiter> findByEmail(String email);
	
	public String updateRole(Integer id, Recruiter recruiter);
	
	public String updateStatus(Integer id, Recruiter recruiter);

}
