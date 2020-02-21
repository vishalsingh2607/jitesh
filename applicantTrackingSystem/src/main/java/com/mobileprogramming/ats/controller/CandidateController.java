package com.mobileprogramming.ats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.CandidateService;

@RestController
public class CandidateController {
		
     
	@Autowired
	private CandidateService candidateService;

	//Api for fetching all candidate details
	@RequestMapping(value="/allcandidates",method=RequestMethod.GET)
	public ResponseEntity<List<Candidate>>  getAllCandid()
	{
		candidateService.getAllCandidiates();
		return new ResponseEntity<List<Candidate>>(HttpStatus.OK);
	}
	
     //Api for fetching candidate list page wise
	@RequestMapping(value="/candidateslist", method=RequestMethod.GET)
	public ResponseEntity<Page<Candidate>> fetchByPage(Pageable pageable)
	{
		candidateService.findAllByPage(pageable);
		return new ResponseEntity<Page<Candidate>>(HttpStatus.OK);
	}
	
	@RequestMapping("/candidates/{id}")
	public ResponseEntity<Optional<Candidate>> getCandid( @PathVariable Integer id)
	{
		 candidateService.getCandidate(id);
		return new ResponseEntity<Optional<Candidate>>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addcandidates")
	public ResponseEntity<Candidate> addCandid(@RequestBody Candidate candidate)
	{
		candidateService.saveCandidate(candidate);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/updatecandidates/{id}")
	public ResponseEntity<Candidate> updateCandid(@RequestBody Candidate candidate, @PathVariable Integer id)
	{
		candidateService.updateCandidate(id, candidate);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/deletecandidates/{id}")
	public ResponseEntity<Candidate> deleteCandid(@RequestBody Candidate candidate,@PathVariable Integer id)
	{
		candidateService.deleteCandidate(id);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}

	   
	 
}
