package com.mobileprogramming.controller;

import java.util.List;
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

import com.mobileprogramming.model.TeamLead;
import com.mobileprogramming.service.TeamLeadService;

@RestController 
@RequestMapping("teamlead-api")
@CrossOrigin
public class TeamLeadController {
				
	
	@Autowired
	private TeamLeadService service;
	
	@GetMapping(value="/getAllLeads")
	public List<TeamLead> getAllLeads() {
		// TODO Auto-generated method stub
		return service.getAllLeads();
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
	
	@PutMapping("/updateLead/{id}")
	public String updateLead(@PathVariable Integer id, @RequestBody TeamLead teamlead) {
		// TODO Auto-generated method stub
		service.saveLead(teamlead);
		return "Record Updated Successfully";
	}
	
	@DeleteMapping()
	public String deleteLead(@PathVariable Integer id) {
		service.deleteLead(id);
		return "Record Deleted succussfully";
	}
}
