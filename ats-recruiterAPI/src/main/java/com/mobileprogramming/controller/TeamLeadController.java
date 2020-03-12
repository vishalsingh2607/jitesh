package com.mobileprogramming.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.Assigned;
import com.mobileprogramming.model.Recruiter;
import com.mobileprogramming.model.TeamLead;
import com.mobileprogramming.response.Response;
import com.mobileprogramming.service.AssignedService;
import com.mobileprogramming.service.RecruiterService;
import com.mobileprogramming.service.TeamLeadService;

@RestController 
@RequestMapping("teamlead-api")
@CrossOrigin
public class TeamLeadController {
				
	
	@Autowired
	private TeamLeadService service;
	
	@Autowired
	private RecruiterService service2;
	
	
	@Autowired
	private AssignedService assignservice;
	
	@GetMapping(value="/getAllLeads")
	public Response<TeamLead> getAllLeads() {
		Response<TeamLead> response=new Response<>();
		List<TeamLead> list=service.getAllLeads();
		TeamLead[] teamarray=new TeamLead[list.size()];
		list.toArray(teamarray);
		response.setMessage("Team Lead List");
		response.setSuccess(true);
		response.setResponses(teamarray);
		return response;
	}
	
	@GetMapping("/getLeadById/{id}")
	public Optional<TeamLead> getLead(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return service.getLead(id);
	}
	
	@PostMapping("/saveLead")
	public TeamLead saveLead(@RequestBody TeamLead teamlead) {
		// TODO Auto-generated method stub
		
		return service.saveLead(teamlead);
	}
	
	
	
	@DeleteMapping("/deleteLead/{id}")
	public String deleteLead(@PathVariable Integer id) {
		service.deleteLead(id);
		return "Record Deleted succussfully";
	}
}
