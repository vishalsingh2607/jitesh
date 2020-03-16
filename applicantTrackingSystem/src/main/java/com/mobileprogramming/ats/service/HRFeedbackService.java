package com.mobileprogramming.ats.service;

import java.util.List;
import java.util.Optional;

import com.mobileprogramming.ats.dto.HRfeedbackDto;
import com.mobileprogramming.ats.model.Candidate;

public interface HRFeedbackService {

	public List<HRfeedbackDto> getHrFeedback();

	public String addHrFeedback(Candidate candidate, Long id);

	public String updateHrFeedback(Candidate candidate, Long id);

	public Optional<Candidate> getHrFeedbackForCandidate(Long id);

	public String deleteHrFeedback(Long id);

}
