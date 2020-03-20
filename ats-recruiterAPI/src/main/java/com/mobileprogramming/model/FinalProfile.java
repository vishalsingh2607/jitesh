package com.mobileprogramming.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="FinalProfile")
@JsonInclude(value = Include.NON_NULL)
public class FinalProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	private String reportingHead;
	
	
	private String department;
	
	private String offeredStatus;
	
	private String designation;
	
	private String finalComments;
	
   //private String profileStatus;
   
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
   private Date dateofjoining;

public String getReportingHead() {
	return reportingHead;
}

public void setReportingHead(String reportingHead) {
	this.reportingHead = reportingHead;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getOfferedStatus() {
	return offeredStatus;
}

public void setOfferedStatus(String offeredStatus) {
	this.offeredStatus = offeredStatus;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getFinalComments() {
	return finalComments;
}

public void setFinalComments(String finalComments) {
	this.finalComments = finalComments;
}





public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}








public Date getDateofjoining() {
	return dateofjoining;
}

public void setDateofjoining(Date dateofjoining) {
	this.dateofjoining = dateofjoining;
}

public FinalProfile()
{
	
}

public FinalProfile(Integer id, String reportingHead, String department, String offeredStatus, String designation,
		String finalComments, Date dateofjoining) {
	super();
	this.id = id;
	this.reportingHead = reportingHead;
	this.department = department;
	this.offeredStatus = offeredStatus;
	this.designation = designation;
	this.finalComments = finalComments;
	this.dateofjoining = dateofjoining;
}

   
   
}
