package com.mobileprogramming.ats.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobileprogramming.ats.dto.CandidateProfileDetailsDto;
import com.mobileprogramming.ats.dto.HRfeedbackDto;
import com.mobileprogramming.ats.dto.CandidateJoiningDetailsDto;
import com.mobileprogramming.ats.model.Candidate;

@Component
public class ConverterService {

	@Autowired
	private ModelMapper modelMapper;
	
	public CandidateProfileDetailsDto convertToCandidatePersonalDetailsDto(Candidate candidate) {
		return modelMapper.map(candidate,CandidateProfileDetailsDto.class);
	}
	
	public HRfeedbackDto convertToHrFeedbackDetailsDto(Candidate candidate) {
		return modelMapper.map(candidate,HRfeedbackDto.class);
	}
	
	public CandidateJoiningDetailsDto convertToJoiningCandidateDetailsDto(Candidate candidate) {
		return modelMapper.map(candidate,CandidateJoiningDetailsDto.class);
	}

}
