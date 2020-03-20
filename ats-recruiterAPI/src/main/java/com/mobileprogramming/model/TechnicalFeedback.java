package com.mobileprogramming.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="TechnicalFeedback")
@JsonInclude(value = Include.NON_NULL)
public class TechnicalFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer technicalRating;
	
	private Integer communicationRating;
	
	private String technicalInterviewer;
	
	private String department;
	
	private String comment;
	
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date interviewDate;
	
//	private String profileStatus;

	


	

	

	public Integer getTechnicalRating() {
		return technicalRating;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTechnicalRating(Integer technicalRating) {
		this.technicalRating = technicalRating;
	}

	public Integer getCommunicationRating() {
		return communicationRating;
	}

	public void setCommunicationRating(Integer communicationRating) {
		this.communicationRating = communicationRating;
	}

	public String getTechnicalInterviewer() {
		return technicalInterviewer;
	}

	public void setTechnicalInterviewer(String technicalInterviewer) {
		this.technicalInterviewer = technicalInterviewer;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



	

	
	
	public TechnicalFeedback(Integer id, Integer technicalRating, Integer communicationRating,
			String technicalInterviewer, String department, String comment, Date interviewDate) {
		super();
		this.id = id;
		this.technicalRating = technicalRating;
		this.communicationRating = communicationRating;
		this.technicalInterviewer = technicalInterviewer;
		this.department = department;
		this.comment = comment;
		this.interviewDate = interviewDate;
	}

	public TechnicalFeedback()
	{
		
	}
}
