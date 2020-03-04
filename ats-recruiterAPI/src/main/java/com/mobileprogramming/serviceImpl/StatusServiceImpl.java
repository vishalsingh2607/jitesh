package com.mobileprogramming.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.Status;
import com.mobileprogramming.repository.StatusRepository;
import com.mobileprogramming.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusRepository repo;
	
	@Override
	public String updateStatus(Integer id, Status status) {
		repo.save(status);
		return "Status updated";
	}

	@Override
	public String createStatus(Status status) {
		repo.save(status);
		return "Status created";
	}

	@Override
	public List<Status> getAllStatus() {
		
		return repo.findAll();
	}

	@Override
	public String deleteStatus(Integer id) {
		repo.deleteById(id);
		return "Status deleted";
	}

	

	

}
