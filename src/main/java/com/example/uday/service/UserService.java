package com.example.uday.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uday.dao.AddressDB;
import com.example.uday.dao.UserInformationDB;
import com.example.uday.exception.UserNotFoundException;
import com.example.uday.pojo.Address;

@Service
public class UserService {
	
	@Autowired
	private UserInformationDB userInformationDB;
	
	@Autowired 
	private AddressDB addressDB;
	
	public List<Address> getAddressByUserEmailId(String emailId){
		return addressDB.findByUserEmailId(emailId);
	}
	
	public Address addAddressToUser(Address address, String emailId) {
		return userInformationDB.findById(emailId).map(
				user -> {
					address.setUser(user);
					return addressDB.save(address);
				}).orElseThrow(() -> new UserNotFoundException("User not exists:"+ emailId));
	}
	
}
