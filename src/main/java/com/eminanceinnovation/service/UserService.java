package com.eminanceinnovation.service;
import java.util.List;
import java.util.Set;

import com.eminanceinnovation.model.User;
import com.eminanceinnovation.model.UserRole;

public interface UserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception ;

	//get user by username
	public User getUser(String  username);
	
	//delete user by id
	public void deleteUser(Long userId);

	//get all the users
	public List<User> getAllUsers();

	public User updateUser(User user);
	
}
