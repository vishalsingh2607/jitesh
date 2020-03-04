package com.mobileprogramming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.Status;
import com.mobileprogramming.serviceImpl.StatusServiceImpl;

@RestController
public class StatusController {
	@Autowired
	private StatusServiceImpl statusservice;
	 
	/*
	 * @RequestMapping(value="/getAllStatus",method = RequestMethod.GET) public
	 * List<Status> getAllStatus() { return statusservice.getAllStatus(); }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value="/createStatus") public
	 * String addStatus(@RequestBody Status status) {
	 * statusservice.createStatus(status); return "Status added successfully"; }
	 */
		  
		  @RequestMapping(method = RequestMethod.PUT,value="/updateStatus/{id}") 
		  public String updateStatus(@RequestBody Status status, @PathVariable Integer id) 
		  { 
			  statusservice.createStatus(status);
			  return "Record Updated Successfully";
		  }
		  
	/*
	 * @RequestMapping(method = RequestMethod.DELETE,value="/deleteStatus/{id}")
	 * public String deleteStatus(@PathVariable Integer id) {
	 * statusservice.deleteStatus(id); return "Record Deleted Successfully"; }
	 */
}
