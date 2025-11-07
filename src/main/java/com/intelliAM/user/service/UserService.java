package com.intelliAM.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelliAM.user.Entity.User;
import com.intelliAM.user.Repository.UserFollowerRepository;
import com.intelliAM.user.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserFollowerRepository userFollowerRepository;
	
	// TODO: getUserByUserName with custom Query
	public User getUserByID(final Long id) { 
		Optional<User> userObj = userRepository.findById(id);
		return userObj.get();
		} 
	
	public User saveUser(User userDetails) {
		User userObj = userRepository.save(userDetails);
		return userObj;
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		// TODO: check delete successfully and can return boolean value
	}
	
	public List<Long> getFollowedUsers(Long user_id){
		
		return userFollowerRepository.findAllFollowedIdByUserid(user_id); // List can be empty
	}
	
	// Get all user for security implementation
	public List<User> getAllUser(){
		return userRepository.findAll();
	}

}
