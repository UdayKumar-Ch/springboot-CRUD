package com.example.uday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.uday.pojo.UserInformation;
import com.example.uday.service.UserService;

@RestController("/user")
public class UserEndpointController {

	@Autowired
	private UserService userService;

	@GetMapping("/fetchuser/{userId}")
	public UserInformation getUserInformation(@PathVariable long userId) {
		return null;
	}
	
	@PostMapping("/createuser")
	public UserInformation createUser(@RequestBody UserInformation user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/updateuser")
	public boolean updateUser(@RequestBody UserInformation user) {
		return false;
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public long deleteUser(@PathVariable long userId) {
		return 0l;
	}
}
