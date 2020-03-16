package com.mobileprogramming.ats.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.dto.HRfeedbackDto;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.service.ConverterService;
import com.mobileprogramming.ats.service.HRFeedbackService;

@Service
public class HRFeedbackServiceImpl implements HRFeedbackService {

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private ConverterService converterservice;

	@Override
	public List<HRfeedbackDto> getHrFeedback() {
		return candidateRepository.findAll().stream().map(converterservice::convertToHrFeedbackDetailsDto)
				.collect(Collectors.toList());

	}

	@Override
	public String addHrFeedback(Candidate candidate, Long id) {

		candidateRepository.findById(id).map(newcandidate -> {
			newcandidate.setTechnicalinterviewername(candidate.getTechnicalinterviewername());
			newcandidate.setTechnicalrating(candidate.getTechnicalrating());
			newcandidate.setCommunicationrating(candidate.getCommunicationrating());
			newcandidate.setComments(candidate.getComments());
			newcandidate.setDepartment(candidate.getDepartment());
			newcandidate.setJoiningstatus(candidate.getJoiningstatus());

			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			newcandidate.setHrFeedbackCreatedAt(date);
			return candidateRepository.save(newcandidate);
		});
		return "succesfully added Hrfeedback details";
	}

	@Override
	public String updateHrFeedback(Candidate candidate, Long id) {

		candidateRepository.findById(id).map(newcandidate -> {
			newcandidate.setTechnicalinterviewername(candidate.getTechnicalinterviewername());
			newcandidate.setTechnicalrating(candidate.getTechnicalrating());
			newcandidate.setCommunicationrating(candidate.getCommunicationrating());
			newcandidate.setComments(candidate.getComments());
			newcandidate.setDepartment(candidate.getDepartment());
			newcandidate.setJoiningstatus(candidate.getJoiningstatus());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			newcandidate.setHrFeedbackUpdatedAt(date);
			return candidateRepository.save(newcandidate);
		});

		return "Hrfeedback details updated successfully";
	}

	@Override
	public Optional<Candidate> getHrFeedbackForCandidate(Long id) {

		return candidateRepository.findhrfeedbackbyid(id);
	}

	@Override
	public String deleteHrFeedback(Long id) {
		candidateRepository.findById(id).map(newcandidate -> {
			newcandidate.setTechnicalinterviewername(null);
			newcandidate.setTechnicalrating(null);
			newcandidate.setCommunicationrating(null);
			newcandidate.setDepartment(null);
			newcandidate.setJoiningstatus(null);
			return candidateRepository.save(newcandidate);
		});

		return "Feedback deleted";
	}

}
