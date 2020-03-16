package com.mobileprogramming.ats.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User")
public class User {
	
    @Id
	@Column(name="Team_Id")
	private int teamId;
	
	@Column(name="Name")
	@NotNull
	private String name;
	
	@Column(name="Role")
	@NotNull
	private String role;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Phone_No")
	private long mobile;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Status")
	private String status;
	
	
	@Column(name="CreatedAt")
	private String createdAt;
	
	@Column(name="UpdatedAt")
	private String updatedAt;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	public User() {
		
	}



	

	public User(int teamId, String name, String role, String email, long mobile, String location, String status,
			String createdAt, String updatedAt) {
		this.teamId = teamId;
		this.name = name;
		this.role = role;
		this.email = email;
		this.mobile = mobile;
		this.location = location;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User [teamId=" + teamId + ", name=" + name + ", role=" + role + ", email=" + email + ", mobile="
				+ mobile + ", location=" + location + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
	
}
