package com.exam.examserver.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.repo.RoleRepository;
import com.exam.examserver.repo.UserRepository;
import com.exam.examserver.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	// Creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles)  throws Exception{
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local !=null)
		{
			System.out.println("User is already there !!");
			throw new Exception("User is already present !!");
		}
		else {
			// user create 
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRole().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}
	// getting user by username
	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}
	@Override
	public User updateUser(User user) {
//		User local = this.userRepository.findByUsername(user.getUsername());
//		for(UserRole ur:userRoles) {
//			roleRepository.save(ur.getRole());
//		}
//		
//		user.getUserRole().addAll(userRoles);
//		local = this.userRepository.save(user);
	
	return this.userRepository.save(user);
	}

}
