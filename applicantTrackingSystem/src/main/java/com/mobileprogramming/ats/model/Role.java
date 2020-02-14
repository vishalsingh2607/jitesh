package com.mobileprogramming.ats.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {


	@Id
	@Column(name="RoleId")
	private int roleId;
	
	@Column(name="Role")
	private String role;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", role=" + role + "]";
	}

	public Role() {
		
	}


	
	
	
}
