package com.mobileprogramming.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.Credentials;
import com.mobileprogramming.model.Recruiter;
import com.mobileprogramming.response.Response;
import com.mobileprogramming.serviceImpl.RecruiterServiceImpl;

@RestController
@RequestMapping("/login-api")
@CrossOrigin
public class LoginController {

	@Autowired
	private RecruiterServiceImpl service;

	// @CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response<Recruiter> checkUser(@RequestBody Recruiter recruiter) {
		Response<Recruiter> response = new Response<Recruiter>();
		try {
	
		//Recruiter recruiter=new Recruiter();
		
		String name = recruiter.getEmail();
		String pwd = recruiter.getPassword();
	
		

		Optional<Recruiter> isExist = service.findByEmailAndPassword(name, pwd);
		Recruiter recruiter2=isExist.get();
		if (isExist.isPresent()) {
			if(recruiter.getStatus()!=null) {
				if(recruiter.getStatus().booleanValue()!=false)
				{
				recruiter2.setStatus(recruiter.getStatus());
			}else {
				response.setMessage("Wait for admin approval");
				response.setSuccess(false);
			}
			}
			else {
				response.setMessage("Status cant be null");
			    response.setSuccess(false);
			}
		} 

		response.setMessage("Login Successfull");
		response.setSuccess(true);
		response.setResponse(recruiter2);

		
		}catch(NoSuchElementException e)
		{
			response.setMessage("Bad Credentials");
			response.setSuccess(false);
		}
		catch(Exception e)
		{
			response.setMessage("Internal Server Error");
			response.setSuccess(false);
		}
		return response;
	}
}
