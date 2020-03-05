package com.mobileprogramming.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity
@Table(name ="recruiter_registration")
@JsonInclude(value = Include.NON_NULL)
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
     private String username;
     private String email;
     private long contactno;
     private String location;
     private String password;
     private String role;
     private String Status;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Recruiter(Integer id, String username, String email, long contactno, String location, String password,
			String role, String status) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.contactno = contactno;
		this.location = location;
		this.password = password;
		this.role = role;
		Status = status;
	}
    public Recruiter()
    {
    	
    }
	/*
	 * @OneToOne(targetEntity = Login.class,cascade = CascadeType.ALL) private Login
	 * login;
	 */
	
	/*
	 * public Login getLogin() { return login; } public void setLogin(Login login) {
	 * this.login = login; }
	 */
	
	
	
}
