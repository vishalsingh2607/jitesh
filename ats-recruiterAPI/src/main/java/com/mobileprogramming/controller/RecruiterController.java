package com.mobileprogramming.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.Recruiter;
import com.mobileprogramming.response.Response;
import com.mobileprogramming.serviceImpl.RecruiterServiceImpl;

@RestController
@RequestMapping("/recruiter-api")
@CrossOrigin
public class RecruiterController {

	@Autowired
	private RecruiterServiceImpl service;

	// @CrossOrigin
	@RequestMapping(value = "/getAllRecruiters", method = RequestMethod.GET)
	public Response<Recruiter> getAllRecruiters() {
		Response<Recruiter> response = new Response<Recruiter>();
		List<Recruiter> recruiters = service.getAllRecruiters();
		response.setMessage("Recruiters List");
		response.setSuccess(true);
		Recruiter[] myArray = new Recruiter[recruiters.size()];
		recruiters.toArray(myArray);
		response.setResponses(myArray);
		return response;
	}

	// @CrossOrigin
	@RequestMapping("/getRecruiterById/{id}")
	public Response<Recruiter> getRecruiter(@PathVariable Integer id) {
		Response<Recruiter> response = new Response<>();
		Optional<Recruiter> optional = service.getRecruiter(id);
		response.setMessage("Recruiters By Id");
		response.setSuccess(true);
		response.setResponse(optional.get());
		return response;

	}

	// @CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/createRecruiter")
	public Response<Recruiter> addRecruiter(@RequestBody Recruiter recruiter) {
		Response<Recruiter> response = new Response<Recruiter>();
		try {
			if (recruiter != null) {
				if (recruiter.getEmail() != null) {

				} else {
					response.setMessage("email cant be null!");
					response.setSuccess(false);
					// response.setResponse(recruiter2);
					return response;
				}

				if (recruiter.getContactno() != 0) {

				}

			} else {
				response.setMessage("contact should not be null!");
				response.setSuccess(false);
				// response.setResponse(recruiter2);
				return response;
			}

			if (recruiter.getLocation() != null) {

			} else {
				response.setMessage("location should not be null!");
				response.setSuccess(false);
				// response.setResponse(recruiter2);
				return response;
			}
			if (recruiter.getUsername() != null) {

			} else {
				response.setMessage("username cant not be null!");
				response.setSuccess(false);
				// response.setResponse(recruiter2);
				return response;
			}

			if (recruiter.getPassword() != null) {

			} else {
				response.setMessage("password cant not be null!");
				response.setSuccess(false);
				// response.setResponse(recruiter2);
				return response;
			}

			if (recruiter.getRole() != null) {

			} else {
				response.setMessage("role cant not be null!");
				response.setSuccess(false);
				// response.setResponse(recruiter2);
				return response;
			}

			
			Recruiter recruiter2 = service.saveRecruiter(recruiter);
			response.setResponse(recruiter2);
			response.setMessage("Successfully Submitted Recruiter Profile. Please wait for Admin Approval");
			response.setSuccess(true);

		} catch (DataIntegrityViolationException e) {
			response.setMessage("Email already exist!");
			response.setSuccess(false);
			// TODO: handle exception
		} catch (Exception e) {
			response.setMessage("Internal Server Error !");
			response.setSuccess(false);
		}
		// return response;

		return response;
	}

	// @CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, value = "/updateRecruiter/{id}")
	public Response<Recruiter> updateRecruiter(@RequestBody Recruiter recruiter, @PathVariable Integer id) {
		Response<Recruiter> response = new Response<>();
		if (id != null) {
			Optional<Recruiter> reOptional = service.getRecruiter(id);
			if (reOptional.isPresent()) {
				Recruiter recruiter2 = reOptional.get();
				if (recruiter != null) {
					if (recruiter.getEmail() != null) {

						recruiter2.setEmail(recruiter.getEmail());
					}
					if (recruiter.getContactno() != 0) {
						recruiter2.setContactno(recruiter.getContactno());
					}
					if (recruiter.getLocation() != null && recruiter.getLocation() != ""
							&& recruiter.getLocation().trim().length() > 0) {
						recruiter2.setLocation(recruiter.getLocation());
					}
					/*
					 * if (recruiter.isStatus() != null) {
					 * recruiter2.setStatus(recruiter.isStatus()); }
					 */
				} else {
					response.setMessage("Please provide recruiter info !");
					response.setSuccess(false);
					return response;
				}
			} else {

				response.setMessage("Please provide valid user id !");
				response.setSuccess(false);
				return response;
			}
			service.saveRecruiter(reOptional.get());
			response.setResponse(reOptional.get());
		} else {
			response.setMessage("Id can not be empty or null !");
			response.setSuccess(false);
			return response;
		}

		response.setMessage("Record Updated Successfully!");
		response.setSuccess(true);
		return response;
	}

	// @CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteRecruiter/{id}")
	public Response<Recruiter> deleteRecruit(@PathVariable Integer id) {
		Response<Recruiter> response = new Response<>();
		if (id != null) {
			Optional<Recruiter> reOptional = service.getRecruiter(id);
			if (reOptional.isPresent()) {
				service.deleteRecruiter(id);
				response.setMessage("Record Deleted Successfully!");
				response.setSuccess(true);

			} else {
				response.setMessage("please provide valid id!");
				response.setSuccess(false);
				return response;
			}

		} /*
			 * else { response.setMessage("id cant be null!"); response.setSuccess(false);
			 * return response; }
			 */
		return response;
	}

	@PutMapping(value = "/updateStatus/{id}")
	public Response<Recruiter> updateStatus(@RequestBody Recruiter recruiter, @PathVariable Integer id) {
		Response<Recruiter> response = new Response<Recruiter>();
		Optional<Recruiter> reOptional = service.getRecruiter(id);
		Recruiter recruiter2 = reOptional.get();
		if (id != null) {
			
			if (reOptional.isPresent()) {
				
				if (recruiter.getStatus() != null) {
					recruiter2.setStatus(recruiter.getStatus());
				}
			}
			service.saveRecruiter(reOptional.get());
			response.setStatus(recruiter2.getStatus());

		} else {
			response.setMessage("id cant be null!");
			response.setSuccess(false);
			return response;
		}

		response.setMessage("Status updated successfully");
		response.setSuccess(true);
		return response;

	}

	@PutMapping(value = "/updateRole/{id}")
	public Response<Recruiter> updateRole(@RequestBody Recruiter recruiter, @PathVariable Integer id) {
		Response<Recruiter> response=new Response<>();
		Optional<Recruiter> reOptional=service.getRecruiter(id);
		Recruiter recruiter2=reOptional.get();
		if(id!=null)
		{
			
			if(reOptional.isPresent())
			{
				
				if(recruiter.getRole()!=null) {
					recruiter2.setRole(recruiter.getRole());
				}
			}
			service.saveRecruiter(reOptional.get());
			response.setRole(recruiter2.getRole());
			
		}else {
			response.setMessage("id cant be null!");
			response.setSuccess(false);
			return response;
		}
		
		response.setMessage("Role updated Successfully");
		response.setSuccess(true);
		return response;
	}
}
