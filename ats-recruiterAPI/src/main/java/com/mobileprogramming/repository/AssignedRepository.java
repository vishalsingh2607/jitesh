package com.mobileprogramming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.model.Assigned;

@Repository
public interface AssignedRepository extends JpaRepository<Assigned,Integer> {
	
	
	
	List<Assigned> findByTlId(Integer tl);

	
	
	
	

}
