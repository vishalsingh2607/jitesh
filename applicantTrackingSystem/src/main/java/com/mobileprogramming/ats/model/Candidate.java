package com.mobileprogramming.ats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="Candidate")
public class Candidate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SerialNo")
	private int serialNo;
	
	@Size(max=50)
	@Column(name="Name")
	private String name;
	
	@Size(max=50)
	@Column(name="Technology")
	private String technology;
	
	
	@Column(name="Contact_No")
	private Long contactNo;
	
	@Column(name="HRR_Date")
	private String hRRDate;
	
	@Column(name="Exp_In_Years")
	private Float expInYears;
	
	@Column(name="Technical_Rating")
	private Integer technicalRating;
	
	@Column(name="Com_R")
	private Integer comR;
	
	@Column(name="Current_Salary_In_LPA")
	private Float currentSalaryInLPA;	
	
	@Column(name="Salary_Offered_In_LPA")
	private Float salaryOfferedInLPA;
	
	@Column(name="Joining_Time_In_Days")
	private Integer joiningTimeInDays;
	
	@Column(name="Offer_Status")
	private String offerStatus;
	
	@Column(name="Offered_On")
	private String offeredOn;
	
	@Column(name="Joining_On")
	private String joiningOn;
	
	@Column(name="Joining_Status")
	private String joiningStatus;
	
	@Column(name="Recruiter")
	private String recruiter;
	
	@Column(name="Reporting_Head")
	private String reportingHead;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Technical_Interviewer")
	private String technicalInterviewer;
	
	@Column(name="Comments")
	private String comments;
	
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String gethRRDate() {
		return hRRDate;
	}

	public void sethRRDate(String hRRDate) {
		this.hRRDate = hRRDate;
	}

	public Float getExpInYears() {
		return expInYears;
	}

	public void setExpInYears(Float expInYears) {
		this.expInYears = expInYears;
	}

	public Integer getTechnicalRating() {
		return technicalRating;
	}

	public void setTechnicalRating(Integer technicalRating) {
		this.technicalRating = technicalRating;
	}

	public Integer getComR() {
		return comR;
	}

	public void setComR(Integer comR) {
		this.comR = comR;
	}

	public Float getCurrentSalaryInLPA() {
		return currentSalaryInLPA;
	}

	public void setCurrentSalaryInLPA(Float currentSalaryInLPA) {
		this.currentSalaryInLPA = currentSalaryInLPA;
	}

	public Float getSalaryOfferedInLPA() {
		return salaryOfferedInLPA;
	}

	public void setSalaryOfferedInLPA(Float salaryOfferedInLPA) {
		this.salaryOfferedInLPA = salaryOfferedInLPA;
	}

	public Integer getJoiningTimeInDays() {
		return joiningTimeInDays;
	}

	public void setJoiningTimeInDays(Integer joiningTimeInDays) {
		this.joiningTimeInDays = joiningTimeInDays;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getOfferedOn() {
		return offeredOn;
	}

	public void setOfferedOn(String offeredOn) {
		this.offeredOn = offeredOn;
	}

	public String getJoiningOn() {
		return joiningOn;
	}

	public void setJoiningOn(String joiningOn) {
		this.joiningOn = joiningOn;
	}

	public String getJoiningStatus() {
		return joiningStatus;
	}

	public void setJoiningStatus(String joiningStatus) {
		this.joiningStatus = joiningStatus;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getReportingHead() {
		return reportingHead;
	}

	public void setReportingHead(String reportingHead) {
		this.reportingHead = reportingHead;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTechnicalInterviewer() {
		return technicalInterviewer;
	}

	public void setTechnicalInterviewer(String technicalInterviewer) {
		this.technicalInterviewer = technicalInterviewer;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
	public Candidate() {
		
		
	}

	public Candidate(Integer serialNo, String name, String technology, Long contactNo, String hRRDate, Float expInYears,
			Integer technicalRating, Integer comR, Float currentSalaryInLPA, Float salaryOfferedInLPA,
			Integer joiningTimeInDays, String offerStatus, String offeredOn, String joiningOn, String joiningStatus,
			String recruiter, String reportingHead, String location, String technicalInterviewer, String comments) {
		super();
		this.serialNo = serialNo;
		this.name = name;
		this.technology = technology;
		this.contactNo = contactNo;
		this.hRRDate = hRRDate;
		this.expInYears = expInYears;
		this.technicalRating = technicalRating;
		this.comR = comR;
		this.currentSalaryInLPA = currentSalaryInLPA;
		this.salaryOfferedInLPA = salaryOfferedInLPA;
		this.joiningTimeInDays = joiningTimeInDays;
		this.offerStatus = offerStatus;
		this.offeredOn = offeredOn;
		this.joiningOn = joiningOn;
		this.joiningStatus = joiningStatus;
		this.recruiter = recruiter;
		this.reportingHead = reportingHead;
		this.location = location;
		this.technicalInterviewer = technicalInterviewer;
		this.comments = comments;
		
	}

	@Override
	public String toString() {
		return "Candidate [serialNo=" + serialNo + ", name=" + name + ", technology=" + technology + ", contactNo="
				+ contactNo + ", hRRDate=" + hRRDate + ", expInYears=" + expInYears + ", technicalRating="
				+ technicalRating + ", comR=" + comR + ", currentSalaryInLPA=" + currentSalaryInLPA
				+ ", salaryOfferedInLPA=" + salaryOfferedInLPA + ", joiningTimeInDays=" + joiningTimeInDays
				+ ", offerStatus=" + offerStatus + ", offeredOn=" + offeredOn + ", joiningOn=" + joiningOn
				+ ", joiningStatus=" + joiningStatus + ", recruiter=" + recruiter + ", reportingHead=" + reportingHead
				+ ", location=" + location + ", technicalInterviewer=" + technicalInterviewer + ", comments=" + comments
				+ "]";
	}

	
	

}
