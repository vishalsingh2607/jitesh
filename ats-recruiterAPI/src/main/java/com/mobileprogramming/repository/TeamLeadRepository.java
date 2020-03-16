package com.mobileprogramming.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.model.TeamLead;

@Repository
public interface TeamLeadRepository extends CrudRepository<TeamLead, Integer>{
			
}
