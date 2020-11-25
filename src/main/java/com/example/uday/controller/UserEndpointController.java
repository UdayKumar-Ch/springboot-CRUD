package com.example.uday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uday.dao.pojo.Address;
import com.example.uday.dao.pojo.UserInformation;
import com.example.uday.pojo.UserAddress;
import com.example.uday.service.UserService;

@RestController
@RequestMapping("/user")
public class UserEndpointController {

	private static final String SUCCESSFULLY_DELETED = " Successfully deleted";
	
	@Autowired
	private UserService userService;

	@GetMapping("/fetchuser/{userEmailId}")
	public UserAddress getUserInformation(@PathVariable String userEmailId) {
		return userService.getUserInformation(userEmailId);
	}
	
	@PostMapping("/createuser")
	public UserInformation createUser(@RequestBody UserInformation user) {
		return userService.createNewUser(user);
	}
	
	@PutMapping("/updateuser")
	public UserInformation updateUser(@RequestBody UserInformation user) {
		return userService.updateUserInformation(user);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return userId + SUCCESSFULLY_DELETED;
	}
		
	@PostMapping("/addaddress/{userId}")
	public Address addAddress(@RequestBody Address address, @PathVariable String userId) {
		return userService.addAddressToUser(address, userId);
	}
	
	@PutMapping("/updateaddress")
	public Address modifyAddress(@RequestBody Address toBeModifiedAddress) {
		return userService.updateAddressByAddressId(toBeModifiedAddress);
	}
	
	@DeleteMapping("/deleteaddress/{addressid}")
	public String deleteAddress(@PathVariable Long addressId) {
		userService.deleteAddressById(addressId);
		return "Successfully deleted";
	}
	
}
