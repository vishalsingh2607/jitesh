package com.mobileprogramming.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	 * @GetMapping(value = "/getAllDetails") public Response<Assigned>
	 * getAllDetails(Integer id) {
	 * 
	 * 
	 * Assigned ass=new Assigned();
	 * 
	 * Response<Assigned> response=new Response<>();
	 * 
	 * recruitservice.getRecruiter(assignservice.findByRecruiterId(id));
	 * 
	 * return response;
	 * 
	 * }
	 */
	 

	/*
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
	public Response<Assigned> assignLead(@PathVariable Integer recuriterId, @PathVariable Integer teamLeadId) {

		Response<Assigned> response = new Response<>();
		TeamLead teamlead = new TeamLead();

		Assigned assign = new Assigned();

		Optional<TeamLead> optional = tlservice.getLead(teamLeadId);
		TeamLead teamlead2 = optional.get();

		Optional<Recruiter> optionalRe = recruitservice.getRecruiter(recuriterId);

		try {
			if (recuriterId != null) {

				if (optionalRe.isPresent()) {
					assign.setRecruiterId(optionalRe.get().getId());
					assign.setTlId(teamlead2.getId());
					assign.setStatusCheck(true);

				} else {
					response.setMessage("field is not present in table");
					response.setSuccess(false);
					return response;
				}
			} else {
				response.setMessage("id should not be null");
				response.setSuccess(false);
				return response;
			}

			assignservice.saveDetails(assign);
			recruitservice.saveRecruiter(optionalRe.get());

			response.setMessage("TeamLead Assigned Successfully");
			response.setSuccess(true);
			response.setResponse(assign);
		} catch (NoSuchElementException e) {

			response.setMessage("No Value Present");
			response.setSuccess(false);
		}
		return response;
	}

	@GetMapping("/getByTeamLead/{teamLeadId}")
	public Response<Recruiter> getAssignLead(@PathVariable Integer teamLeadId) {

		Response<Recruiter> response = new Response<>();

		Optional<Recruiter> optional = recruitservice.getRecruiter(teamLeadId);
		Recruiter rec = optional.get();
		Optional<TeamLead> optional2 = tlservice.getLead(teamLeadId);
		TeamLead teamlead2 = optional2.get();

		rec.setContactno(null);
		rec.setPassword(null);
		rec.setStatus(null);

		// TeamLead teamlead2=new TeamLead();
		response.setResponse(rec);

		List<Recruiter> recruiters = new ArrayList<>();
		try {
			if (teamLeadId != null) {

				if (optional.isPresent()) {

					List<Assigned> assigned = assignservice.getByTlId(teamlead2.getId());

					for (Assigned assign : assigned) {

						Optional<Recruiter> recruiter_ = recruitservice.getRecruiter(assign.getRecruiterId());
						recruiter_.get().setPassword(null);
						recruiter_.get().setContactno(null);
						recruiter_.get().setStatus(null);
						recruiter_.get().setRole(null);

						recruiters.add(recruiter_.get());

					}

				} else {
					response.setMessage("field is not present in table");
					response.setSuccess(false);
					return response;
				}
			} else {
				response.setMessage("id should not be null");
				response.setSuccess(false);
				return response;
			}

			Recruiter[] myArray = new Recruiter[recruiters.size()];
			recruiters.toArray(myArray);
			response.setResponses(myArray);

			response.setMessage("List");
			response.setSuccess(true);
		} catch (NoSuchElementException e) {

			response.setMessage("No Value Present");
			response.setSuccess(false);
		}
		return response;
	}

	@GetMapping("/getByRecruiter/{recruiterId}")
	public Response<Assigned> getAssiged(@PathVariable Integer recruiterId) {

		Response<Assigned> response = new Response<>();

		List<Assigned> assign = assignservice.findByRecruiterId(recruiterId);

		Optional<Recruiter> rec = recruitservice.getRecruiter(recruiterId);

		Recruiter rec2 = rec.get();
		rec2.setContactno(null);
		rec2.setPassword(null);
		rec2.setRole(null);
		rec2.setStatus(null);

		Assigned ass = assign.get(0);

		response.setMessage("Assigned Record");
		response.setSuccess(true);
		response.setResponse(ass);
		response.setRecruiter(rec2);

		return response;

	}

}
