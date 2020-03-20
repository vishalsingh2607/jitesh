package com.mobileprogramming.ats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.dto.HRfeedbackDto;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.HRFeedbackService;

@RestController("/hrfeedbackapi")
public class TechnicalFeedbackController {
	@Autowired
	private HRFeedbackService hrfeedbackService;

	@Autowired
	private CandidateRepository candidateRepository;

	// Api for fetching HR feedback details
	@RequestMapping(value = "hrfeedbackapi/getallfeedback", method = RequestMethod.GET)
	public List<HRfeedbackDto> getHrFeedback() {

		if (hrfeedbackService.getHrFeedback().isEmpty()) {
			throw new RuntimeException("No feedback data is avilable");
		} else {
			return hrfeedbackService.getHrFeedback();
		}

	}

	// Api for adding HR feedback
	@RequestMapping(value = "hrfeedbackapi/addhrfeedback/{id}", method = RequestMethod.POST)
	public String addHrFeedback(Candidate candidate, @PathVariable Long id) {

		if (candidateRepository.findById(id).isPresent() == true) {
			return hrfeedbackService.addHrFeedback(candidate, id);
		} else {
			throw new RuntimeException("Invalid Id");
		}
		

	}

	// Update Api For Hrfeedback
	@RequestMapping(value = "hrfeedbackapi/updatehrfeedback/{id}", method = RequestMethod.PUT)
	public String updateHrFeedBack(Candidate candidate, @PathVariable Long id) {

		if (candidateRepository.findById(id).isPresent() == true) {
			return hrfeedbackService.updateHrFeedback(candidate, id);
		} else {
			throw new RuntimeException("Invalid Id");
		}

	}

	@RequestMapping(value = "hrfeedbackapi/getfeedback/{id}", method = RequestMethod.GET)
	public Optional<Candidate> getHrFeedbackForCandidate(@PathVariable Long id) {

		if (hrfeedbackService.getHrFeedbackForCandidate(id).isPresent() == true) {
			return hrfeedbackService.getHrFeedbackForCandidate(id);
		} else {
			throw new RuntimeException("Invalid Id");
		}
	}

	@RequestMapping(value = "hrfeedbackapi/deletehrfeedback//{id}", method = RequestMethod.DELETE)
	public String deleteHrFeedback(Candidate candidate, @PathVariable Long id) {
		if (candidateRepository.findById(id).isPresent() == true) {
			return hrfeedbackService.deleteHrFeedback(id);
		} else {
			throw new RuntimeException("Invalid Id");
		}
	}

}
