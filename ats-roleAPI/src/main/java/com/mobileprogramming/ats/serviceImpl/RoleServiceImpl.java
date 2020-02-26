package com.mobileprogramming.ats.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.ats.dao.RoleRepository;
import com.mobileprogramming.ats.model.Role;
import com.mobileprogramming.ats.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
private RoleRepository roleRepository;
	
	//Get All Roles
	public List<Role> getAllRoles()
	{
		List<Role> list=new ArrayList<Role>();
		roleRepository.findAll().forEach(list::add);
		return list;
		
	}
	
	//Get Role By Id
	public Optional<Role> getRole(Integer id)
	{
		return roleRepository.findById(id);
		
	}
	
	//Create
	public String saveRole(Role role)
	{
		roleRepository.save(role);
		return "Record Created";
	}
	
	//Update
	public String updateRole(Integer id,Role role)
	{
		roleRepository.save(role);
		return "Record updated";
	}
	
	//Delete
	public String deleteRole(Integer id)
	{
		roleRepository.deleteById(id);
		return "Record Deleted";
	}
}
