package com.mobileprogramming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mobileprogramming.model.Status;

@Service
public interface StatusService {
	//GET
	public List<Status> getAllStatus();
	//CREATE
	public String createStatus(Status status);
	// Update
			public String updateStatus(Integer id, Status status);
}
