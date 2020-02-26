package com.mobileprogramming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="recruiter_registration")
public class Recruiter {
	
	@Id
	 private Integer id;
     private String username;
     private String email;
     private long contactno;
     private String location;
     private String password;
     private String role;
     private boolean status;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Recruiter()
	{
		
	}
	public Recruiter(Integer id, String username, String email, long contactno, String location, String password) {
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.contactno = contactno;
		this.location = location;
		this.password = password;
	}
	public Recruiter(Integer id, String username, String email, long contactno, String location, String password,
			String role, boolean status) {
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.contactno = contactno;
		this.location = location;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	
}
