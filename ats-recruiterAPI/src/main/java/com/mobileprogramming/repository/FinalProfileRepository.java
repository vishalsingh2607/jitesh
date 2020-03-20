package com.mobileprogramming.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.model.FinalProfile;

@Repository
public interface FinalProfileRepository extends CrudRepository<FinalProfile, Integer>{

	
}
