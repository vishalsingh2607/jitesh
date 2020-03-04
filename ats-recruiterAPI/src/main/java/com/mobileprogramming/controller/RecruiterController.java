package com.mobileprogramming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.Recruiter;
import com.mobileprogramming.serviceImpl.RecruiterServiceImpl;




@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RecruiterController {
	

	@Autowired
	private RecruiterServiceImpl service;
	
	

	@RequestMapping(value="/getAllRecruiters",method = RequestMethod.GET)
	public List<Recruiter> getAllRecruiters()
	{
		return service.getAllRecruiters();
	}
		
	@RequestMapping("/getRecruiterById/{id}")
	public Optional<Recruiter> getRecruiter(@PathVariable Integer id)
	{
		return service.getRecruiter(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/createRecruiter")
	public String addRecruiter(@RequestBody Recruiter recruiter)
	{
		 service.saveRecruiter(recruiter);
		return "Successfully Submitted Recruiter Profile. Please wait for Admin Approval";
	}
	
	
	
	  @RequestMapping(method = RequestMethod.PUT,value="/updateRecruiter/{id}") 
	  public String updateRecruiter(@RequestBody Recruiter recruiter, @PathVariable Integer id) 
	  { 
		  service.saveRecruiter(recruiter);
		  return "Record Updated Successfully";
	  }
	 
	
	
	@RequestMapping(method = RequestMethod.DELETE,value="/deleteRecruiter/{id}")
	public String deleteRecruit(@PathVariable Integer id)
	{
		service.deleteRecruiter(id);
		return "Record Deleted Successfully";
	}
	}



