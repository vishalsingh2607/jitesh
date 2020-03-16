package com.mobileprogramming.ats.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.dto.CandidateProfileDetailsDto;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.CandidateProfileService;

@RestController("/candidateapi")
public class CandidateProfileController {

	@Autowired
	private CandidateProfileService candidateService;

	@Autowired
	private CandidateRepository candidateRepository;

	// Api for fetching candidate profiles
	@RequestMapping(value = "candidateapi/getcandidateprofiles", method = RequestMethod.GET)
	public List<CandidateProfileDetailsDto> getCandidateProfiles() {
		if (candidateService.getCandidateProfiles().isEmpty()) {
			throw new RuntimeException("No Candidate Profile is avilable");
		} else {
			return candidateService.getCandidateProfiles();
		}
	}

	// Api for generating reports of candidate
	/*
	 * @RequestMapping(value = "candidateapi/report", method = RequestMethod.GET)
	 * public ResponseEntity<List<Object[]>> generatereports() { if
	 * (candidateService.generateRepo().isEmpty()) { return new
	 * ResponseEntity<List<Object[]>>(HttpStatus.NO_CONTENT); } else { return new
	 * ResponseEntity<List<Object[]>>(candidateService.generateRepo(),
	 * HttpStatus.OK); } }
	 */

	/*
	 * @GetMapping("candidateapi/report/{format}") public String
	 * generateReport(@PathVariable String format) throws FileNotFoundException,
	 * JRException { return reportService.exportReport(format); }
	 */
	// Api for fetching candidate list page wise
	@RequestMapping(value = "candidateapi/candidateslist", method = RequestMethod.GET)
	public Page<Candidate> fetchByPage(Pageable pageable) {

		if (candidateService.findAllByPage(pageable).isEmpty()) {
			throw new RuntimeException("No Candidate details is avilable, Please add candidate details first");
		} else {
			return candidateService.findAllByPage(pageable);
		}

	}

	@RequestMapping(value = "candidateapi/candidatedetails/{id}", method = RequestMethod.GET)
	public Optional<Candidate> getCandid(@PathVariable Long id) {
		if (candidateRepository.findById(id).isPresent() == true) {
			return candidateService.getCandidateById(id);
		} else {
			throw new RuntimeException("Invalid Id");
		}
	}

	@RequestMapping(value = "candidateapi/addcandidateprofile", method = RequestMethod.POST)
	public String addCandidProfile(@Valid Candidate candidate, MultipartFile file) {

		return candidateService.saveCandidateProfile(candidate, file);

	}

	@RequestMapping(value = "candidateapi/updatecandidateprofile/{id}", method = RequestMethod.PUT)
	public String updateCandidateProfile(Candidate candidate, @PathVariable Long id, MultipartFile file) {

		if (candidateRepository.findById(id).isPresent() == true) {
			return candidateService.updateCandidateProfile(id, candidate, file);
		} else {
			throw new RuntimeException("Invalid Id");
		}

	}

	@RequestMapping(value = "candidateapi/deletecandidate/{id}", method = RequestMethod.DELETE)
	public String deleteCandid(Candidate candidate, @PathVariable Long id) {

		if (candidateRepository.findById(id).isPresent() == true) {
			return candidateService.deleteCandidate(id);
		} else {
			throw new RuntimeException("Invalid Id");
		}
	}

}
