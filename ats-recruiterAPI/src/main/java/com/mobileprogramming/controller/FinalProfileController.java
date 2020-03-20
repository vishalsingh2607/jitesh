package com.mobileprogramming.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.FinalProfile;
import com.mobileprogramming.response.Response;
import com.mobileprogramming.service.FinalProfileService;


@RestController
@RequestMapping("/finalprofile-api")
@CrossOrigin
public class FinalProfileController {

	@Autowired
	private FinalProfileService service;
	
	@RequestMapping(value = "/addprofile/{id}", method = RequestMethod.POST)
	public Response<FinalProfile> addDetails(@RequestBody FinalProfile profile,@PathVariable int id)
	{
		Response<FinalProfile> response=new Response<FinalProfile>();
		
		
		
		FinalProfile fp=service.addFinal(profile);
		fp.setId(null);
		response.setStatus(true);
		response.setMessage("Final Profile Submitted");
		response.setResponse(fp);
		return response;
	}

	
}
