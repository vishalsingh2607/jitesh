package com.mobileprogramming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobileprogramming.model.TeamLead;

@Service
public interface TeamLeadService {
	
	public List<TeamLead> getAllLeads();

	public Optional<TeamLead> getLead(Integer id);
	
	

    public TeamLead saveLead(TeamLead teamlead);

	public String updateLead(Integer id, TeamLead teamlead);
	
	public String deleteLead(Integer id);
}
