package com.mobileprogramming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobileprogramming.model.TechnicalFeedback;




@Service
public interface TechnicalFeedbackService {

	
	public List<TechnicalFeedback> getHrFeedback();

	public TechnicalFeedback addTechnicalFeedback(TechnicalFeedback feedback);

	public String updateTechnicalFeedback(TechnicalFeedback feeback, int id);

	public Optional<TechnicalFeedback> getTechnicalFeedbackForCandidate(int id);

	public String deleteTechnicalFeedback(int id);
}
