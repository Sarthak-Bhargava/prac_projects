package com.exam.examserver.services;
import java.util.Set;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
public interface UserService {

	// Creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	// get user by username
	public User getUser(String username);
	
	// delete user by id 
	public void deleteUser(Long userId);
	
	// update user by user id
	public User updateUser(User user);
}
