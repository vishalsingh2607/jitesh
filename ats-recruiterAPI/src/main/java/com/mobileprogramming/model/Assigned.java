package com.mobileprogramming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Assigned {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ASSIG_ID")
	private int id;
	
	
	@JsonIgnore
	@Column(name="TL_Id")
	private Integer tlId;
	
	
	transient Recruiter teamLead;
	
	transient Recruiter recruiter;
	
	public void setTlId(Integer tlId) {
		this.tlId = tlId;
	}


	@JsonIgnore
	@Column(name="RECRUITER_ID")
	private Integer recruiterId;
	
	@Column(name="Status_Check")
	private boolean statusCheck;
	
	public boolean isStatusCheck() {
		return statusCheck;
	}
	public void setStatusCheck(boolean statusCheck) {
		this.statusCheck = statusCheck;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getTlId() {
		return tlId;
	}
	
	public Integer getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Integer recruiterId) {
		this.recruiterId = recruiterId;
	}
	public Assigned(int id, Integer tlId, Integer recruiterId, boolean statusCheck) {
		super();
		this.id = id;
		this.tlId = tlId;
		this.recruiterId = recruiterId;
		this.statusCheck = statusCheck;
	}
	
	
	
	
	public Assigned()
	{
		
	}
	
	public Recruiter getTeamLead() {
		return teamLead;
	}
	public void setTeamLead(Recruiter teamLead) {
		this.teamLead = teamLead;
	}
	public void setTeamLead1(Recruiter teamLead) {
		this.recruiter = teamLead;
	}
	public Recruiter getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	
	
}
