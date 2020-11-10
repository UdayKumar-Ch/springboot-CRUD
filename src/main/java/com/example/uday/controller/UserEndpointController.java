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
import com.example.uday.pojo.Address;
import com.example.uday.pojo.UserInformation;
import com.example.uday.service.UserService;

@RestController
@RequestMapping("/user")
public class UserEndpointController {

	@Autowired
	private UserService userService;

	@GetMapping("/fetchuser/{userEmailId}")
	public UserInformation getUserInformation(@PathVariable String userEmailId) {
		return userService.getUserInformation(userEmailId);
	}
	
	@PostMapping("/createuser")
	public UserInformation createUser(@RequestBody UserInformation user) {
		return userService.createNewUser(user);
	}
	
	@PutMapping("/updateuser")
	public boolean updateUser(@RequestBody UserInformation user) {
		return false;
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public long deleteUser(@PathVariable long userId) {
		return 0l;
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
