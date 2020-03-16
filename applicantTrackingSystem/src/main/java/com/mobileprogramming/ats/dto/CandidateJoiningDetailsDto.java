package com.mobileprogramming.ats.dto;

import java.sql.Date;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class CandidateJoiningDetailsDto {

	@JsonProperty(value = "candidateid")
	private String candidateid;
	
	@JsonProperty(value = "joiningstatus")
	private String joiningstatus;
	
	@JsonProperty(value = "reportingheadname")
	private String reportingheadname;
	
	@JsonProperty(value = "department")
	private String department;
	
	@Column(name = "OfferedOn")
	private Date offeredon;
	
	@Column(name = "JoiningTimeInDays")
	private int joiningtimeindays;

	public String getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}

	public String getJoiningstatus() {
		return joiningstatus;
	}

	public void setJoiningstatus(String joiningstatus) {
		this.joiningstatus = joiningstatus;
	}

	public String getReportingheadname() {
		return reportingheadname;
	}

	public void setReportingheadname(String reportingheadname) {
		this.reportingheadname = reportingheadname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getOfferedon() {
		return offeredon;
	}

	public void setOfferedon(Date offeredon) {
		this.offeredon = offeredon;
	}

	public int getJoiningtimeindays() {
		return joiningtimeindays;
	}

	public void setJoiningtimeindays(int joiningtimeindays) {
		this.joiningtimeindays = joiningtimeindays;
	}
	
	
}
