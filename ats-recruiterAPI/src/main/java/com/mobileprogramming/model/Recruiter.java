package com.mobileprogramming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "recruiter_registration")
@JsonInclude(value = Include.NON_NULL)
public class Recruiter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 20)
	private String username;

	@Column(unique = true, length = 50)
	private String email;

	@Column(length = 25)
	private long contactno;

	@Column(length = 20)
	private String location;

	@Column(length = 50)
	//@JsonIgnore
	private String password;

	@Column(length = 20)
	private String role;

	@Column(length = 20)
	private Boolean status;


	
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Recruiter(Integer id, String username, String email, long contactno, String location, String password,
			String role, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.contactno = contactno;
		this.location = location;
		this.password = password;
		this.role = role;
		this.status = status;
		
	}
	
	

	

	public Recruiter() {

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
