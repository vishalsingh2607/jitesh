package com.mobileprogramming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.model.Assigned;

@Repository
public interface AssignedRepository extends JpaRepository<Assigned,Integer> {
	
	/*
	 * @Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery =
	 * true)
	 */
	List<Assigned> findByTlId(Integer tl);

	List<Assigned> findByRecruiterId(Integer t1);
	
	

}
