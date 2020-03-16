package com.mobileprogramming.ats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.ats.model.Role;
import com.mobileprogramming.ats.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getAllRoles")
	public List<Role> getAllRoles()
	{
		return roleService.getAllRoles();
	}
	
	@RequestMapping("/getRoleById/{id}")
	public Optional<Role> getRole( @PathVariable Integer id)
	{
		return roleService.getRole(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/createRole")
	public String addRole(@RequestBody Role role)
	{
		roleService.saveRole(role);
		return "Record created successfully";
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/updateRole/{id}")
	public String updateRole(@RequestBody Role role, @PathVariable Integer id)
	{
		roleService.updateRole(id, role);
		return "Record Updated successfully";
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/deleteRole/{id}")
	public String deleteRole(@PathVariable Integer id)
	{
		roleService.deleteRole(id);
		return "Record Deleted Successfully";
	}
}
