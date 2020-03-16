package com.mobileprogramming.ats.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CandidateProfileDetailsDto {

	@JsonProperty(value = "candidateid")
	private String candidateid;

	@JsonProperty(value = "candidatename")
	private String candidatename;

	@JsonProperty(value = "fathername")
	private String fathername;

	@JsonProperty(value = "dob")
	private Date dob;

	@JsonProperty(value = "emailid")
	private String emailid;

	@JsonProperty(value = "contactno")
	private String contactno;

	@JsonProperty(value = "technology")
	private String technonology;

	@JsonProperty(value = "location")
	private String location;

	@JsonProperty(value = "designation")
	private String designation;

	@JsonProperty(value = "totalexperience")
	private float totalexperience;

	@JsonProperty(value = "currentsalaryinlpa")
	private float currentsalaryinlpa;

	@JsonProperty(value = "expectedsalaryinlpa")
	private float expectedsalaryinlpa;

	@JsonProperty(value = "noticeperiodindays")
	private int noticeperiodindays;

	@JsonProperty(value = "recruiterid")
	private String recruiterid;

	@JsonProperty(value = "recruitername")
	private String recruitername;

	@JsonProperty(value = "offerstatus")
	private String offerstatus;

	@JsonProperty(value = "resumestoragepath")
	private String resumestoragepath;

	public String getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}

	public String getCandidatename() {
		return candidatename;
	}

	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getTechnonology() {
		return technonology;
	}

	public void setTechnonology(String technonology) {
		this.technonology = technonology;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getTotalexperience() {
		return totalexperience;
	}

	public void setTotalexperience(float totalexperience) {
		this.totalexperience = totalexperience;
	}

	public float getCurrentsalaryinlpa() {
		return currentsalaryinlpa;
	}

	public void setCurrentsalaryinlpa(float currentsalaryinlpa) {
		this.currentsalaryinlpa = currentsalaryinlpa;
	}

	public float getExpectedsalaryinlpa() {
		return expectedsalaryinlpa;
	}

	public void setExpectedsalaryinlpa(float expectedsalaryinlpa) {
		this.expectedsalaryinlpa = expectedsalaryinlpa;
	}

	public int getNoticeperiodindays() {
		return noticeperiodindays;
	}

	public void setNoticeperiodindays(int noticeperiodindays) {
		this.noticeperiodindays = noticeperiodindays;
	}

	public String getRecruiterid() {
		return recruiterid;
	}

	public void setRecruiterid(String recruiterid) {
		this.recruiterid = recruiterid;
	}

	public String getRecruitername() {
		return recruitername;
	}

	public void setRecruitername(String recruitername) {
		this.recruitername = recruitername;
	}

	public String getOfferstatus() {
		return offerstatus;
	}

	public void setOfferstatus(String offerstatus) {
		this.offerstatus = offerstatus;
	}

	public String getResumestoragepath() {
		return resumestoragepath;
	}

	public void setResumestoragepath(String resumestoragepath) {
		this.resumestoragepath = resumestoragepath;
	}

}
