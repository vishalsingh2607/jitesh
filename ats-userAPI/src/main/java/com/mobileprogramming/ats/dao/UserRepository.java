package com.mobileprogramming.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.ats.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
}
