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
	
	@RequestMapping("/roles")
	public List<Role> getAllRoles()
	{
		return roleService.getAllRoles();
	}
	
	@RequestMapping("/roles/{id}")
	public Optional<Role> getRole( @PathVariable Integer id)
	{
		return roleService.getRole(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/roles")
	public void addRole(@RequestBody Role role)
	{
		roleService.saveRole(role);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/roles/{id}")
	public void updateRole(@RequestBody Role role, @PathVariable Integer id)
	{
		roleService.updateRole(id, role);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/roles/{id}")
	public void deleteRole(@PathVariable Integer id)
	{
		roleService.deleteRole(id);
	}
}
