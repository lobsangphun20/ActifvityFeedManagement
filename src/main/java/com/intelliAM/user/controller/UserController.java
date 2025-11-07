package com.intelliAM.user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intelliAM.user.Entity.User;
import com.intelliAM.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// new user registration api endpoint
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User userObj) {
		User savedUserObj = userService.saveUser(userObj);
		return new ResponseEntity<>(savedUserObj, HttpStatus.CREATED);
	}
	
	// TODO: getting user by Principle name
	@GetMapping("/{userId}") 
	public ResponseEntity<User> getUser(@RequestParam long userId) {
		User userObj = userService.getUserByID(userId);
		// Ideally map userObj to UserDTO (Data Transfer Object) using mapper libraray
		return new ResponseEntity<>(userObj, HttpStatus.OK);
	}
	
	// To get all other user it has followed
	@GetMapping("/userfollowed/{userId}")
	public ResponseEntity<List<Long>> getFollowedId(@RequestParam long userId){
		List<Long> listOfFollowedUserId = userService.getFollowedUsers(userId);
		return new ResponseEntity<>(listOfFollowedUserId, HttpStatus.OK);
	}
	// test purpose API for security
	@GetMapping("/all")
	public List<User> getAllUser(Principal principal) {
		// return userService.getAllUser();
		List<User> tempList = userService.getAllUser();
		
		// Temp testing purpose
		User u1 = new User();
		User u2 = new User();
		u1.setUserName(principal.getName());
		u1.setEmail("lobsang@gmail.com");
		u2.setUserName("phuntsok");
		u2.setEmail("phuntsok@gmail.com");
		tempList.add(u1);
		tempList.add(u2);
		
		return tempList;
	}
	/*
	 * TODO: 
	 * More API related to User Management can be added later
	 */
}
