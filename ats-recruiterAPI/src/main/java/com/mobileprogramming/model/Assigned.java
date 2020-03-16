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
	
	@Column(name="RECURITER_ID")
	private int recuriterId;
	
	
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
	public int getRecuriterId() {
		return recuriterId;
	}
	public void setRecuriterId(int recuriterId) {
		this.recuriterId = recuriterId;
	}
	
	
	
}
