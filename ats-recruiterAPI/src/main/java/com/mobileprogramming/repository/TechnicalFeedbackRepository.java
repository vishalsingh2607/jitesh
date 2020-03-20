package com.mobileprogramming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.model.TechnicalFeedback;



@Repository
public interface TechnicalFeedbackRepository extends JpaRepository<TechnicalFeedback, Integer>{

}
