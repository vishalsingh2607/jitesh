package com.mobileprogramming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assigned {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ASSIG_ID")
	private int id;
	
	
	@Column(name="TL_Id")
	private int tlId;
	
	@Column(name="RECRUITER_ID")
	private int recruiterId;
	
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
	public int getTlId() {
		return tlId;
	}
	public void setTlId(int tlId) {
		this.tlId = tlId;
	}
	public int getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
	}
	public Assigned(int id, int tlId, int recruiterId, boolean statusCheck) {
		super();
		this.id = id;
		this.tlId = tlId;
		this.recruiterId = recruiterId;
		this.statusCheck = statusCheck;
	}
	
	
	public Assigned()
	{
		
	}
	
}
