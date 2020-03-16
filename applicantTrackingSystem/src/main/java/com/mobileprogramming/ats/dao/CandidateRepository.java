package com.mobileprogramming.ats.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.ats.model.Candidate;

@Repository
public interface CandidateRepository
		extends JpaRepository<Candidate, Long>, PagingAndSortingRepository<Candidate, Long> {

	Object entityManager = null;

	Page<Candidate> findAll(Pageable pageable);

	@Query(value = "SELECT c.technicalrating FROM candidate c where c.candidateid = :id", nativeQuery = true)
	Optional<Candidate> findhrfeedbackbyid(Long id);


//	@Query("SELECT c.serialNo, c.name,c.technology,c.location,c.contactNo FROM Candidate c where c.name"+"Virat")
//	public List<Candidate> finObjects();

}
