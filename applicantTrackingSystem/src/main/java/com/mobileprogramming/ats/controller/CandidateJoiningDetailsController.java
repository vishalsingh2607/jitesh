package com.mobileprogramming.ats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.dto.CandidateJoiningDetailsDto;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.CandidateJoiningDetailsService;

@RestController("/candidatejoiningdetailsapi")
public class CandidateJoiningDetailsController {
	@Autowired
	private CandidateJoiningDetailsService joiningCandidateDetailsService;

	@Autowired
	private CandidateRepository candidateRepository;

	// Api for fetching candidate joining details
	@RequestMapping(value = "candidatejoiningdetailsapi/getcandidatejoiningdetails", method = RequestMethod.GET)
	public List<CandidateJoiningDetailsDto> getCandidateJoiningDetails() {

		if (joiningCandidateDetailsService.getCandidateJoiningDetails().isEmpty()) {
			throw new RuntimeException("No feedback data is avilable");
		} else {
			return joiningCandidateDetailsService.getCandidateJoiningDetails();
		}

	}

	// Api for adding candidate joining details
	@RequestMapping(value = "candidatejoiningdetailsapi/addcandidatejoiningdetails/{id}", method = RequestMethod.POST)
	public String addCandidateJoiningDetails(Candidate candidate, @PathVariable Long id) {

		if (candidateRepository.findById(id).isPresent() == true) {
			return joiningCandidateDetailsService.addCandidateJoiningDetails(candidate, id);
		} else {
			throw new RuntimeException("Invalid Id");
		}

	}

	// Update Api candidate joining details
	@RequestMapping(value = "candidatejoiningdetailsapi/updatecandidatejoiningdetails/{id}", method = RequestMethod.PUT)
	public String updateCandidateJoiningDetails(Candidate candidate, @PathVariable Long id) {

		if (candidateRepository.findById(id).isPresent() == true) {
			return joiningCandidateDetailsService.updateCandidateJoiningDetails(candidate, id);
		} else {
			throw new RuntimeException("Invalid Id");
		}

	}

	@RequestMapping(value = "candidatejoiningdetailsapi/deletecandidatejoiningdetails/{id}", method = RequestMethod.DELETE)
	public String deleteCandidateJoiningDetails(Candidate candidate, @PathVariable Long id) {

		if (candidateRepository.findById(id).isPresent() == true) {
			return joiningCandidateDetailsService.deleteCandidateJoiningDetails(candidate, id);
		} else {
			throw new RuntimeException("Invalid Id");
		}

	}

}
