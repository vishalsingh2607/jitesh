package com.mobileprogramming.ats.service;

import java.util.List;
import java.util.Optional;

import com.mobileprogramming.ats.model.User;

public interface UserService {

	// Get All Users
	public List<User> getAllUsers();

	// Get User By Id
	public Optional<User> getUser(Integer id);

	// Create
	public void saveUser(User user);

	// Update
	public void updateUser(Integer id, User user);

	// Delete
	public void deleteUser(Integer id);
}
