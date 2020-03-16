package com.mobileprogramming.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.Assigned;
import com.mobileprogramming.repository.AssignedRepository;
import com.mobileprogramming.service.AssignedService;

@Service
public class AssignedServiceImpl implements AssignedService{

	@Autowired
	private AssignedRepository repo;
	
	@Override
	public List<Assigned> getAllDetails() {
	
		return repo.findAll();
	}

	@Override
	public Optional<Assigned> getDetails(Integer id) {
		
		return repo.findById(id);
	}

	@Override
	public Assigned saveDetails(Assigned assigned) {
		
		return repo.save(assigned);
	}

	@Override
	public String updateDetails(Integer id, Assigned assigned) {
		repo.save(assigned);
		return "record updated";
	}

	@Override
	public String deleteAssigned(Integer id) {
		repo.deleteById(id);
		return "Record Deleted" ;
	}

	@Override
	public void findByTlId(Integer tl) {
		List<Assigned> assigned = repo.findByTlId(tl);
		for (Assigned assigned2 : assigned) {
			repo.delete(assigned2);
		}
		
		
	}

	

		
	
	

	


}
