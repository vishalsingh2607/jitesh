package com.mobileprogramming.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("assign-api")
public class AssignedController {

	
	@Autowired
	private AssignedService assignservice;
	
	@Autowired
	private TeamLeadService tlservice;
	
	@Autowired
	private RecruiterService recruitservice;
	
	
		
	
	/*
	 * @GetMapping(value="/getAllDetails") public List<Assigned> getAllDetails() {
	 * return assignservice.getAllDetails();
	 * 
	 * }
	 * 
	 * @GetMapping(value="/getByID/{id}") public Optional<Assigned>
	 * getDetails(@PathVariable Integer id) { return assignservice.getDetails(id); }
	 * 
	 * @PostMapping(value="/createDetails") public Assigned saveDetails(@RequestBody
	 * Assigned asigned) { Assigned assign= assignservice.saveDetails(asigned);
	 * return assign; }
	 * 
	 * @PutMapping(value="/updateDetails/{id}") public String
	 * updateDetails(@PathVariable Integer id, @RequestBody Assigned assigned) {
	 * assignservice.saveDetails(assigned); return "Record Updated Successfully"; }
	 * 
	 * @DeleteMapping(value="/deleteDetails/{id}") public String
	 * deleteAssigned(@PathVariable Integer id) { assignservice.deleteAssigned(id);
	 * return "Record Deleted Successfully"; }
	 */
	
	@PutMapping("/assignLead/{recuriterId}/{teamLeadId}")
	public Response<Recruiter> assignLead(@PathVariable Integer recuriterId, @PathVariable Integer teamLeadId) {
		
		Response<Recruiter> response = new Response<>();
		TeamLead teamlead=new TeamLead();
		
		Assigned assign=new Assigned();
		
		
		  Optional<TeamLead> optional=tlservice.getLead(teamLeadId); 
		  TeamLead teamlead2=optional.get(); 
		 
		 
		 
		 
		Optional<Recruiter> optionalRe =recruitservice.getRecruiter(recuriterId);
	
	try {	
		if(recuriterId!=null)
		{
			
			  if(optionalRe.isPresent())
			{
				  assign.setRecuriterId(optionalRe.get().getId());
				  assign.setTlId(teamlead2.getId());
				
				
				
			}else {
				response.setMessage("field is not present in table");
				response.setSuccess(false);
				return response;
			}
		}else {
			response.setMessage("id should not be null");
			response.setSuccess(false);
			return response;
		}
		
		assignservice.saveDetails(assign);
		recruitservice.saveRecruiter(optionalRe.get());
		
		response.setMessage("TeamLead Assigned Successfully");
		response.setSuccess(true);
	}catch(NoSuchElementException e)
	{
		
		response.setMessage("No Value Present");
		response.setSuccess(false);
	}
		return response;
	}
}
