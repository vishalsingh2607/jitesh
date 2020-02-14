package com.mobileprogramming.ats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.CandidateService;

@RestController
public class CandidateController {
		
     
	@Autowired
	private CandidateService candidateService;

	//Api for fetching all candidate details
	@RequestMapping("/allcandidates")
	public List<Candidate> getAllCandid()
	{
		return candidateService.getAllCandidiates();
	}
	
     //Api for fetching candidate list page wise
	@RequestMapping(value="/candidateslist", method=RequestMethod.GET)
	public Page<Candidate> fetchByPage(Pageable pageable)
	{
		return candidateService.findAllByPage(pageable);
	}
	
	@RequestMapping("/candidates/{id}")
	public Optional<Candidate> getCandid( @PathVariable Integer id)
	{
		return candidateService.getCandidate(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/candidates")
	public void addCandid(@RequestBody Candidate candidate)
	{
		candidateService.saveCandidate(candidate);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/candidates/{id}")
	public void updateCandid(@RequestBody Candidate candidate, @PathVariable Integer id)
	{
		candidateService.updateCandidate(id, candidate);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/candidates/{id}")
	public void deleteCandid(@PathVariable Integer id)
	{
		candidateService.deleteCandidate(id);
	}

	   
	 
}
