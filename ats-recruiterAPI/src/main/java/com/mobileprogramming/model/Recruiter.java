package com.mobileprogramming.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name ="recruiter_registration")
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
     
     @OneToOne(targetEntity = Status.class,cascade = CascadeType.ALL)
     private Status stat;
     
     
	
	public Status getStat() {
		return stat;
	}
	public void setStat(Status stat) {
		this.stat = stat;
	}
	private int tl_id;
     private String tl_name;
     
	public int getTl_id() {
		return tl_id;
	}
	public void setTl_id(int tl_id) {
		this.tl_id = tl_id;
	}
	public String getTl_name() {
		return tl_name;
	}
	public void setTl_name(String tl_name) {
		this.tl_name = tl_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	
	
	public Recruiter(Integer id, String username, String email, long contactno, String location, String password,
			String role, Status stat, int tl_id, String tl_name) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.contactno = contactno;
		this.location = location;
		this.password = password;
		this.role = role;
		this.stat = stat;
		this.tl_id = tl_id;
		this.tl_name = tl_name;
	}
}
