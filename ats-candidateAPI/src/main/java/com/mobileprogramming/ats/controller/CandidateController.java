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

@RestController("/candidateapi")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	// Api for fetching all candidate details
	@RequestMapping(value="candidateapi/getAllCandidates", method = RequestMethod.GET)
	public ResponseEntity<List<Candidate>> getAllCandid() {
		if (candidateService.getAllCandidiates().isEmpty()) {
			return new ResponseEntity<List<Candidate>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Candidate>>(candidateService.getAllCandidiates(),HttpStatus.OK);
		}
	}

	// Api for fetching candidate list page wise
	@RequestMapping(value ="candidateapi/getCandidates",method = RequestMethod.GET)
	public ResponseEntity<Page<Candidate>> fetchByPage(Pageable pageable) {

		if (candidateService.findAllByPage(pageable).isEmpty()) {
			return new ResponseEntity<Page<Candidate>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Page<Candidate>>(candidateService.findAllByPage(pageable),HttpStatus.OK);
		}
	}

	@RequestMapping(value="candidateapi/getCandidateById/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Candidate>> getCandid(@PathVariable Integer id) {
		if (candidateService.getCandidate(id).isPresent()) {
			return new ResponseEntity<Optional<Candidate>>(candidateService.getCandidate(id),HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Candidate>>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "candidateapi/addCandidate",method = RequestMethod.POST)
	public ResponseEntity<Candidate> addCandid(@RequestBody Candidate candidate) {
		candidateService.saveCandidate(candidate);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "candidateapi/updateCandidate/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Candidate> updateCandid(@RequestBody Candidate candidate, @PathVariable Integer id) {
		candidateService.updateCandidate(id, candidate);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "candidateapi/deleteCandidate/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Candidate> deleteCandid(@RequestBody Candidate candidate, @PathVariable Integer id) {
		candidateService.deleteCandidate(id);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}

}
