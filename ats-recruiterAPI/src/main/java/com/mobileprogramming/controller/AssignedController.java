package com.mobileprogramming.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
public class AssignedController {

	@Autowired
	private AssignedService assignservice;

	@Autowired
	private TeamLeadService tlservice;

	@Autowired
	private RecruiterService recruitservice;

	@GetMapping(value = "/getAllDetails")
	public Response<List<Assigned>> getAllDetails(Integer id) {

		// Assigned ass=new Assigned();

		Response<List<Assigned>> response = new Response<>();
		List<Recruiter> recruiterlist = new ArrayList<Recruiter>();
		List<TeamLead> teamlist = new ArrayList<>();

		// recruitservice.getRecruiter(assignservice.findByRecruiterId(id));
		Assigned assign2 = new Assigned();
		Recruiter rec = new Recruiter();
		TeamLead tl = new TeamLead();
		List<Assigned> assign = assignservice.getAllDetails();
		List<Assigned> assignlist = new ArrayList<Assigned>();

		for (Assigned ass : assign) {

			Optional<Recruiter> r = recruitservice.getRecruiter(ass.getRecruiterId());

			r.get().setPassword(null);
			//r.get().setId(null);
			r.get().setContactno(null);
			r.get().setRole(null);
			r.get().setStatus(null);
			
			
			assign2.setId(ass.getId());
			assign2.setTlId(null);
			assign2.setRecruiterId(null);
			
			ass.setRecruiter(r.get());
			assign2.setStatusCheck(ass.isStatusCheck());

			Optional<Recruiter> t = recruitservice.getRecruiter(ass.getTlId());
			t.get().setPassword(null);
			//t.get().setId(null);
			t.get().setContactno(null);
			t.get().setRole(null);
			t.get().setStatus(null);
			rec.setId(ass.getRecruiterId());
			rec.setUsername(r.get().getUsername());
			rec.setEmail(r.get().getEmail());
			rec.setLocation(r.get().getLocation());
			
			ass.setTeamLead(t.get());
			

			assignlist.add(ass);
			// recruiterlist.add(rec);
			// teamlist.add(tl);

		}

		response.setMessage("All Records");
		response.setSuccess(true);
		response.setResponse(assignlist);
		return response;

	}

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

		Optional<TeamLead> optional = tlservice.getLead(teamLeadId);
		TeamLead teamlead2 = optional.get();
		Assigned optionalRe = assignservice.findByRecruiterId(recuriterId);
		try {
			if (optionalRe != null) {
				// assign.setRecruiterId(optionalRe.get().getId());
				optionalRe.setTlId(teamlead2.getId());
				optionalRe.setStatusCheck(true);
				assignservice.saveDetails(optionalRe);
				response.setResponse(optionalRe);

			}
			if (optionalRe == null) {
				Assigned assign = new Assigned();
				assign.setRecruiterId(recuriterId);
				assign.setTlId(teamlead2.getId());
				assign.setStatusCheck(true);
				assignservice.saveDetails(assign);
				response.setResponse(assign);
			}
			/*
			 * if (optionalRe != null && recuriterId != null && teamLeadId != null &&
			 * (optionalRe.getRecruiterId() == recuriterId && teamLeadId ==
			 * optional.get().getId())) { response.setMessage("Assigned TL Already Exist");
			 * response.setSuccess(false); return response;
			 * 
			 * }
			 */
			// }

			// recruitservice.saveRecruiter(optionalRe.get());

			response.setMessage("TeamLead Assigned Successfully");
			response.setSuccess(true);

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

		// Assigned a=new Assigned();

		Assigned ass = assignservice.findByRecruiterId(recruiterId);

		//Assigned ass = assign.get(0);

		Optional<Recruiter> rec = recruitservice.getRecruiter(recruiterId);
		rec.get().setPassword(null);
		rec.get().setRole(null);
		rec.get().setStatus(null);
		rec.get().setContactno(null);
		//rec.get().setId(null);
		
		Recruiter rec2 = rec.get();
		Optional<Recruiter> tt = recruitservice.getRecruiter(ass.getTlId());
		tt.get().setPassword(null);
		tt.get().setContactno(null);
		//tt.get().setId(null);
		tt.get().setRole(null);
		tt.get().setStatus(null);
		
		ass.setTeamLead(tt.get());

		ass.setRecruiter(rec2);

		response.setMessage("Assigned Record");
		response.setSuccess(true);
		response.setResponse(ass);

		return response;

	}

	/*
	 * @PutMapping("/updateLead/{recruiterId}/{teamLeadId}") public
	 * Response<Assigned> updateTeamLEad(@PathVariable Integer
	 * recruiterId, @PathVariable Integer teamLeadId) {
	 * 
	 * Response<Assigned> response = new Response<>(); Assigned assign =
	 * assignservice.findByRecruiterId(recruiterId);
	 * 
	 * // Assigned ass=assign.get();
	 * 
	 * if (assign.getRecruiterId() == (recruiterId)) { assign.setTlId(teamLeadId);
	 * // a.setRecruiterId(recruiterId); // a.setStatusCheck(true);
	 * assignservice.saveDetails(assign);
	 * 
	 * } else { response.setMessage("TeamLead already exist");
	 * response.setSuccess(true); response.setResponse(assign); }
	 * 
	 * response.setMessage("TeamLead Updated Successfully");
	 * response.setSuccess(true); response.setResponse(assign); return response;
	 * 
	 * }
	 */

	@PutMapping("/switchLead/{teamLeadIdOld}/{teamLeadId}")
	public Response<List<Assigned>> switchLead(@PathVariable Integer teamLeadIdOld, @PathVariable Integer teamLeadId) {

		Response<List<Assigned>> response = new Response<>();
		List<Assigned> assign = assignservice.getByTlId(teamLeadIdOld);

		for (Assigned ass : assign) {
			ass.setTlId(teamLeadId);
			//ass.setRecruiter(null);
			assignservice.saveDetails(ass);
		}
		response.setMessage("TeamLead Switched Successfully");
		response.setSuccess(true);
		response.setResponse(assign);
		response.setRecruiter(null);
		
		
		return response;

	}

	@DeleteMapping("/delete/{id}")
	public Response<Assigned> delete(@PathVariable Integer id)
	{
		Response<Assigned> response = new Response<>();
		
		
		if (id != null) {
			Optional<Assigned> reOptional = assignservice.getDetails(id);
			if (reOptional.isPresent()) {
				assignservice.deleteAssigned(id);
				response.setMessage("Record Deleted Successfully!");
				response.setSuccess(true);

			} else {
				response.setMessage("please provide valid id!");
				response.setSuccess(false);
				return response;
			}
		
	}
		else {
			response.setMessage("id cannot be null!");
			response.setSuccess(false);
			return response;
		}
		
		
		return response;
	}
}
