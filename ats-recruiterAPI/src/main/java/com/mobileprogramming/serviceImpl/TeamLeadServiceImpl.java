package com.mobileprogramming.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.TeamLead;
import com.mobileprogramming.repository.TeamLeadRepository;
import com.mobileprogramming.service.TeamLeadService;

@Service
public class TeamLeadServiceImpl implements TeamLeadService{

	@Autowired
	private TeamLeadRepository repository;

	@Override
	public List<TeamLead> getAllLeads() {
		// TODO Auto-generated method stub
		return (List<TeamLead>) repository.findAll();
	}

	@Override
	public Optional<TeamLead> getLead(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public TeamLead saveLead(TeamLead teamlead) {
		// TODO Auto-generated method stub
		
		return repository.save(teamlead);
	}

	@Override
	public String updateLead(Integer id, TeamLead teamlead) {
		// TODO Auto-generated method stub
		repository.save(teamlead);
		return "Record Updated";
	}

	@Override
	public String deleteLead(Integer id) {
		repository.deleteById(id);
		return "Record Deleted succussfully";
	}

	

}
