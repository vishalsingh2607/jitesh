package com.mobileprogramming.ats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.model.Role;
import com.mobileprogramming.ats.service.RoleService;

@RestController("/roleapi")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value="/roleapi/roles",method = RequestMethod.GET)
	public ResponseEntity<List<Role>> getAllRoles() {

		if (roleService.getAllRoles().isEmpty()) {
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Role>>(roleService.getAllRoles(),HttpStatus.OK);
		}
	}

	@RequestMapping("/roleapi/role/{id}")
	public ResponseEntity<Optional<Role>> getRole(@PathVariable Integer id) {

		if (roleService.getRole(id).isPresent()) {
			return new ResponseEntity<Optional<Role>>(roleService.getRole(id),HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Role>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/roleapi/role",method = RequestMethod.POST)
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		roleService.saveRole(role);
		return new ResponseEntity<Role>(role, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/roleapi/role/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable Integer id) {
		roleService.updateRole(id, role);
		return new ResponseEntity<Role>(role, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/roleapi/role/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Role> deleteRole(@RequestBody Role role,@PathVariable Integer id) {
		roleService.deleteRole(id);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
}
