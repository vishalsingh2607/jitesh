package com.mobileprogramming.ats.model;

import java.io.Serializable;
import java.util.List;

public class ReportBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int serialNo;
	private String name;
	private String technology;
	private String location;
	private Long contactNo;


    private List<ReportBean> users;
    
	public ReportBean() {

	}

	public ReportBean(int serialNo, String name, String technology, String location, Long contactNo) {
		
		this.serialNo = serialNo;
		this.name = name;
		this.technology = technology;
		this.location = location;
		this.contactNo = contactNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public List<ReportBean> getUsers() {
		return users;
	}

	public void setUsers(List<ReportBean> users) {
		this.users = users;
	}

}
