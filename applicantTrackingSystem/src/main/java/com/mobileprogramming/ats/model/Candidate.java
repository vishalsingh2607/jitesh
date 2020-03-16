package com.mobileprogramming.ats.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Candidate")
public class Candidate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CandidateId")
	private Long candidateid;

	@Size(max = 50)
	@NotNull(message = "Please enter candidatename")
	@Column(name = "CandidateName")
	private String candidatename;

	@NotNull(message = "Please enter fathername")
	@Size(max = 50)
	@Column(name = "FatherName")
	private String fathername;

	@NotNull(message = "Please provide date of birth")
	@Column(name = "Dob")
	private Date dob;

	@NotNull(message = "Please provide valid email id")
	@Email
	@Column(name = "EmailId")
	private String emailid;

	@NotNull(message = "Please provide valid contact number")
	@Size(min = 10, max = 10)
	@Column(name = "ContactNo")
	private String contactno;

	@NotNull(message = "Please enter location")
	@Column(name = "Location")
	private String location;

	@NotNull(message = "Please provide technology details")
	@Column(name = "Technology")
	private String technology;

	@NotNull(message = "Please enter designation")
	@Column(name = "Designation")
	private String designation;

	@NotNull(message = "Please enter total experience")
	@Column(name = "TotalExperience")
	private float totalexperience;

	@NotNull(message = "Please provide current salary details per annum")
	@Column(name = "CurrentSalaryInLpa")
	private float currentsalaryinlpa;

	@NotNull(message = "Please provide expected salary details per annum")
	@Column(name = "ExpectedSalaryInLpa")
	private float expectedsalaryinlpa;

	@NotNull(message = "Please enter notice period details")
	@Column(name = "NoticePeriodInDays")
	private int noticeperiodindays;

	@NotNull(message = "Please enter recruiterid")
	@Column(name = "RecruiterId")
	private String recruiterid;

	@NotNull(message = "Please enter recruitername")
	@Column(name = "RecruiterName")
	private String recruitername;

	@Column(name = "ResumeStoragePath")
	private String resumestoragepath;

	@NotNull(message = "Please enter offerstatus")
	@Column(name = "OfferStatus")
	@Enumerated(EnumType.STRING)
	private OfferStatus offerstatus;

	@Column(name = "TechnicalInterviewerName")
	private String technicalinterviewername;

	@Column(name = "TechnicalRating")
	private String technicalrating;

	@Column(name = "CommunicationRating")
	private String communicationrating;

	@Column(name = "Comments")
	private String comments;

	@Column(name = "Department")
	private String department;

	@Column(name = "JoiningStatus")
	private String joiningstatus;

	@Column(name = "ReportingHeadName")
	private String reportingheadname;

	@Column(name = "OfferedOn")
	private Date offeredon;

	@Column(name = "JoiningTimeInDays")
	private String joiningtimeindays;

	@Column(name="CandidateProfileCreatedAt")
	private Timestamp candidateProfileCreatedAt;
	
	@Column(name="CandidateProfileUpdatedAt")
	private Timestamp candidateProfileUpdatedAt;
	
	@Column(name="HrFeedbackCreatedAt")
	private Timestamp hrFeedbackCreatedAt;
	
	@Column(name="HrFeedbackUpdatedAt")
	private Timestamp hrFeedbackUpdatedAt;
	
	@Column(name="CandidateJoiningDetailCreatedAt")
	private Timestamp candidateJoiningDetailCreatedAt;
	
	@Column(name="CandidateJoiningDetailUpdatedAt")
	private Timestamp candidateJoiningDetailUpdatedAt;
	
	

	public Timestamp getHrFeedbackCreatedAt() {
		return hrFeedbackCreatedAt;
	}

	public void setHrFeedbackCreatedAt(Timestamp hrFeedbackCreatedAt) {
		this.hrFeedbackCreatedAt = hrFeedbackCreatedAt;
	}

	public Timestamp getHrFeedbackUpdatedAt() {
		return hrFeedbackUpdatedAt;
	}

	public void setHrFeedbackUpdatedAt(Timestamp hrFeedbackUpdatedAt) {
		this.hrFeedbackUpdatedAt = hrFeedbackUpdatedAt;
	}

	public Timestamp getCandidateJoiningDetailCreatedAt() {
		return candidateJoiningDetailCreatedAt;
	}

	public void setCandidateJoiningDetailCreatedAt(Timestamp candidateJoiningDetailCreatedAt) {
		this.candidateJoiningDetailCreatedAt = candidateJoiningDetailCreatedAt;
	}

	public Timestamp getCandidateJoiningDetailUpdatedAt() {
		return candidateJoiningDetailUpdatedAt;
	}

	public void setCandidateJoiningDetailUpdatedAt(Timestamp candidateJoiningDetailUpdatedAt) {
		this.candidateJoiningDetailUpdatedAt = candidateJoiningDetailUpdatedAt;
	}

	public Timestamp getCandidateProfileCreatedAt() {
		return candidateProfileCreatedAt;
	}

	public void setCandidateProfileCreatedAt(Timestamp date) {
		this.candidateProfileCreatedAt = date;
	}

	

	public Timestamp getCandidateProfileUpdatedAt() {
		return candidateProfileUpdatedAt;
	}

	public void setCandidateProfileUpdatedAt(Timestamp candidateProfileUpdatedAt) {
		this.candidateProfileUpdatedAt = candidateProfileUpdatedAt;
	}

	public Long getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(Long candidateid) {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
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

	public String getResumestoragepath() {
		return resumestoragepath;
	}

	public void setResumestoragepath(String resumestoragepath) {
		this.resumestoragepath = resumestoragepath;
	}

	public OfferStatus getOfferstatus() {
		return offerstatus;
	}

	public void setOfferstatus(OfferStatus offerstatus) {
		this.offerstatus = offerstatus;
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

	public String getReportingheadname() {
		return reportingheadname;
	}

	public void setReportingheadname(String reportingheadname) {
		this.reportingheadname = reportingheadname;
	}

	public Date getOfferedon() {
		return offeredon;
	}

	public void setOfferedon(Date offeredon) {
		this.offeredon = offeredon;
	}

	public String getJoiningtimeindays() {
		return joiningtimeindays;
	}

	public void setJoiningtimeindays(String joiningtimeindays) {
		this.joiningtimeindays = joiningtimeindays;
	}

}
