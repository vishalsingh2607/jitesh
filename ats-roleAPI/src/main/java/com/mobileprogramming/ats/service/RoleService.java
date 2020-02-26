package com.mobileprogramming.ats.service;

import java.util.List;
import java.util.Optional;

import com.mobileprogramming.ats.model.Role;

public interface RoleService {
	// Get All Roles
	public List<Role> getAllRoles();

	// Get Role By Id
	public Optional<Role> getRole(Integer id);

	// Create
	public String saveRole(Role role);

	// Update
	public String updateRole(Integer id, Role role);

	// Delete
	public String deleteRole(Integer id);
}
