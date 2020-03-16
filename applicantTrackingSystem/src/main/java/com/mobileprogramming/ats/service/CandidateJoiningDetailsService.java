package com.mobileprogramming.ats.service;

import java.util.List;

import com.mobileprogramming.ats.dto.CandidateJoiningDetailsDto;
import com.mobileprogramming.ats.model.Candidate;

public interface CandidateJoiningDetailsService {

	List<CandidateJoiningDetailsDto> getCandidateJoiningDetails();

	String addCandidateJoiningDetails(Candidate candidate, Long id);

	String updateCandidateJoiningDetails(Candidate candidate, Long id);

	String deleteCandidateJoiningDetails(Candidate candidate, Long id);

}
