package com.mobileprogramming.ats.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TechnicalFeedback")
public class TechnicalFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Integer technicalRating;
	
	private Integer communicationRating;
	
	private String technicalInterviewer;
	
	private String department;
	
	private String comment;
	
	private Date interviewDate;
	
	private String profileStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getTechnicalRating() {
		return technicalRating;
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

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}
	
	
}
