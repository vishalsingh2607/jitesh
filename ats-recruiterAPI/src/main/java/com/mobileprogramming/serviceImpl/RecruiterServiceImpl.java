package com.mobileprogramming.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.Recruiter;
import com.mobileprogramming.repository.RecruiterRepository;
import com.mobileprogramming.service.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService{

	@Autowired
	private RecruiterRepository recruiterRepo;
	
	@Override
	public List<Recruiter> getAllRecruiters() {
		
		return recruiterRepo.findAll();
	}

	@Override
	public Optional<Recruiter> getRecruiter(Integer id) {
		
		return recruiterRepo.findById(id);
	}

	@Override
	public Recruiter saveRecruiter(Recruiter recruiter) {
		
		
		return recruiterRepo.save(recruiter);
	}

	@Override
	public String updateRecruiter(Integer id, Recruiter recruiter) {
		recruiterRepo.save(recruiter);
		return "record updated";
	}

	@Override
	public String deleteRecruiter(Integer id) {
		recruiterRepo.deleteById(id);
		return "Record deleted";
	}

	@Override
	public Page<Recruiter> findAllByPage(Pageable pageable) {
		
		return recruiterRepo.findAll(pageable);
	}

	
   @Override
	public Optional<Recruiter> findByEmailAndPassword(String email, String pwd) {
		
		return recruiterRepo.findByEmailAndPassword(email, pwd);
	}

@Override
public Optional<Recruiter> findByEmail(String email) {
	
	return recruiterRepo.findByEmail(email);
}

@Override
public String updateRole(Integer id, Recruiter recruiter) {
	recruiterRepo.save(recruiter);
	return "Role Updated";
}

@Override
public String updateStatus(Integer id, Recruiter recruiter) {
	recruiterRepo.save(recruiter);
	return "Status Updated";
}

}
