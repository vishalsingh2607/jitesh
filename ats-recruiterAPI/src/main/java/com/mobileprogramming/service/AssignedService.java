package com.mobileprogramming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobileprogramming.model.Assigned;

@Service
public interface AssignedService {
	
	public List<Assigned> getAllDetails();

	public Optional<Assigned> getDetails(Integer id);

    public Assigned saveDetails(Assigned asigned);

	public String updateDetails(Integer id, Assigned assigned);
	
	public String deleteAssigned(Integer id);
	
	public void findByTlId(Integer tl);
	
	
	
	public List<Assigned> getByTlId(Integer t1);
	
	public List<Assigned> findByRecruiterId(Integer t1);
	
	
}
