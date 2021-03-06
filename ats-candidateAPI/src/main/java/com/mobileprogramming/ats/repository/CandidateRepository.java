package com.mobileprogramming.ats.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.ats.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>,PagingAndSortingRepository<Candidate, Integer>{
Page<Candidate> findAll(Pageable pageable);
   
}
