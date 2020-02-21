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
import com.mobileprogramming.ats.model.User;
import com.mobileprogramming.ats.service.UserService;

@RestController("/userapi")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userapi/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {

		if (userService.getAllUsers().isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
		}
	}

	@RequestMapping(value="/userapi/user/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> getCandid(@PathVariable Integer id) {
		if (userService.getUser(id).isPresent()) {
			return new ResponseEntity<Optional<User>>(userService.getUser(id),HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/userapi/user",method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/userapi/user/{id}",method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
		userService.updateUser(id, user);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}

	@RequestMapping( value = "/userapi/user/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@RequestBody User user,@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
}
