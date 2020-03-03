package com.mobileprogramming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
