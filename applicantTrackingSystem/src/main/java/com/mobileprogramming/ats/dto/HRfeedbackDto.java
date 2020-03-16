package com.mobileprogramming.ats.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class HRfeedbackDto {
	
	@JsonProperty(value="candidateid")
	private String candidateid;

	@JsonProperty(value = "technicalinterviewername")
	private String technicalinterviewername;
	
	@JsonProperty(value = "technicalrating")
	private String technicalrating;
	
	@JsonProperty(value = "communicationrating")
	private String communicationrating;
	
	@JsonProperty(value = "comments")
	private String comments;
	
	@JsonProperty(value = "department")
	private String department;
	
	@JsonProperty(value = "joiningstatus")
	private String joiningstatus;

	public String getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}

	public String getTechnicalinterviewername() {
		return technicalinterviewername;
	}

	public void setTechnicalinterviewername(String technicalinterviewername) {
		this.technicalinterviewername = technicalinterviewername;
	}

	public String getTechnicalrating() {
		return technicalrating;
	}

	public void setTechnicalrating(String technicalrating) {
		this.technicalrating = technicalrating;
	}

	public String getCommunicationrating() {
		return communicationrating;
	}

	public void setCommunicationrating(String communicationrating) {
		this.communicationrating = communicationrating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJoiningstatus() {
		return joiningstatus;
	}

	public void setJoiningstatus(String joiningstatus) {
		this.joiningstatus = joiningstatus;
	}
	
	
	
	
}
