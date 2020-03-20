package com.mobileprogramming.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.TechnicalFeedback;
import com.mobileprogramming.repository.TechnicalFeedbackRepository;
import com.mobileprogramming.service.TechnicalFeedbackService;



@Service
public class TechnicalFeedbackServiceImpl implements TechnicalFeedbackService {

	
	
	@Autowired
	private TechnicalFeedbackRepository repo;
	
	@Override
	public List<TechnicalFeedback> getHrFeedback() {
		
		return repo.findAll();
		
		
	}

	@Override
	public TechnicalFeedback addTechnicalFeedback(TechnicalFeedback feedback) {
		
		return repo.save(feedback);
	}

	@Override
	public String updateTechnicalFeedback(TechnicalFeedback feedback, int id) {
		repo.save(feedback);
		
		return "FeedBack Updated";
	}

	@Override
	public Optional<TechnicalFeedback> getTechnicalFeedbackForCandidate(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public String deleteTechnicalFeedback(int id) {
		repo.deleteById(id);
		return "Feeback Deleted";
	}

}
