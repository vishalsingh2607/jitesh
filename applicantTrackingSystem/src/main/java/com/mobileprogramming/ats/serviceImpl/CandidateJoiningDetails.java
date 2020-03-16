package com.mobileprogramming.ats.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.dto.CandidateJoiningDetailsDto;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.CandidateJoiningDetailsService;
import com.mobileprogramming.ats.service.ConverterService;

@Service
public class CandidateJoiningDetails implements CandidateJoiningDetailsService {

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private ConverterService converterservice;

	@Override
	public List<CandidateJoiningDetailsDto> getCandidateJoiningDetails() {
		return candidateRepository.findAll().stream().map(converterservice::convertToJoiningCandidateDetailsDto)
				.collect(Collectors.toList());
	}

	@Override
	public String addCandidateJoiningDetails(Candidate candidate, Long id) {

		candidateRepository.findById(id).map(newcandidate -> {
			newcandidate.setJoiningstatus(candidate.getJoiningstatus());
			newcandidate.setReportingheadname(candidate.getReportingheadname());
			newcandidate.setDepartment(candidate.getDepartment());
			newcandidate.setOfferedon(candidate.getOfferedon());
			newcandidate.setJoiningtimeindays(candidate.getJoiningtimeindays());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			newcandidate.setCandidateJoiningDetailCreatedAt(date);
			return candidateRepository.save(newcandidate);
		});
		return "succesfully added candidate joining details";
	}

	@Override
	public String updateCandidateJoiningDetails(Candidate candidate, Long id) {
		candidateRepository.findById(id).map(newcandidate -> {
			newcandidate.setJoiningstatus(candidate.getJoiningstatus());
			newcandidate.setReportingheadname(candidate.getReportingheadname());
			newcandidate.setDepartment(candidate.getDepartment());
			newcandidate.setOfferedon(candidate.getOfferedon());
			newcandidate.setJoiningtimeindays(candidate.getJoiningtimeindays());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			newcandidate.setCandidateJoiningDetailUpdatedAt(date);
			return candidateRepository.save(newcandidate);
		});
		return "Candidate joining details updated successfully";
	}

	@Override
	public String deleteCandidateJoiningDetails(Candidate candidate, Long id) {

		candidateRepository.findById(id).map(newcandidate -> {
			newcandidate.setJoiningstatus(null);
			newcandidate.setReportingheadname(null);
			newcandidate.setDepartment(null);
			newcandidate.setOfferedon(null);
			newcandidate.setJoiningtimeindays(null);
			return candidateRepository.save(newcandidate);
		});
		return "Candidate joining details deleted";
	}

}
