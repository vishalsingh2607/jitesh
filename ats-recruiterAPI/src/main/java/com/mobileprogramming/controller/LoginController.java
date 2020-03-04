package com.mobileprogramming.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.Credentials;
import com.mobileprogramming.model.Recruiter;
import com.mobileprogramming.serviceImpl.LoginService;
import com.mobileprogramming.serviceImpl.RecruiterServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private RecruiterServiceImpl service;
	
		@RequestMapping( value = "/login", method = RequestMethod.POST)
		public Optional<Recruiter> checkUser(HttpServletRequest req,HttpServletResponse res ,@RequestBody Credentials credential)
		{
			
			String name=credential.getEmail();
			String pwd=credential.getPassword();
			Recruiter recruiter = null;
			if(new LoginService().check(name,pwd))
			{
				
				//res.setStatus(200);
				return service.findByEmail(name);
			}
			else {
				//res.setStatus(403);
				return service.findByEmail(name);
		
			}
		}
}
