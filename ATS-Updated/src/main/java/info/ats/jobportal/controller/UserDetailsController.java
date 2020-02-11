package info.ats.jobportal.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.ats.jobportal.model.UserDetails;
import info.ats.jobportal.service.UserDetailsService;



@RestController
@RequestMapping("/")
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userdetailsservice;
	
	

	
	//Get All Candidate Details
	@GetMapping("/getAllCandidateDetails")
	public List<UserDetails> get() {
		return userdetailsservice.get();
	}
	
	
	
	//Create Candidate Details Api
	@PostMapping("/addCandidateDetails")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserDetails> addUserDetails(@RequestBody UserDetails userdetailsobj){
		userdetailsservice.addUserDetails(userdetailsobj);
		return new ResponseEntity<UserDetails>(userdetailsobj,HttpStatus.CREATED);
	}
	

	
	
	// Update Candidate Api
//	@PutMapping("/updateCandidateDetails")
//	public CandidateDetails update(@RequestBody CandidateDetails candidatedetailsobj) {
//		candidatedetailsservice.addCandidateDetails(candidatedetailsobj);
//		return candidatedetailsobj;
//	}
}
