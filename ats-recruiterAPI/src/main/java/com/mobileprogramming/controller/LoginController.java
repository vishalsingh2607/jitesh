package com.mobileprogramming.controller;

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
	public Response<Recruiter> checkUser(HttpServletRequest req, HttpServletResponse res, @RequestBody Credentials credential) {
		Response<Recruiter> response = new Response<Recruiter>();
		Recruiter recruiter=new Recruiter();
		
		String name = credential.getEmail();
		String pwd = credential.getPassword();
		

		Optional<Recruiter> isExist = service.findByEmailAndPassword(name, pwd);
		Recruiter recruiter2=isExist.get();
		if (isExist.isPresent()) {
			if(recruiter.getStatus()!=false)
			{
					recruiter2.setStatus(recruiter.getStatus());
				//	response.setStatus(recruiter2.getStatus());
			
			}else {
				response.setMessage("Can not login:Approval required by Admin ");
				response.setSuccess(false);
			}
		} else {
			
			response.setMessage("Bad Credentials");
			response.setSuccess(false);

		}

		response.setMessage("Login Successfull");
		response.setSuccess(true);
		response.setResponse(isExist.get());

		return response;
	}
}
