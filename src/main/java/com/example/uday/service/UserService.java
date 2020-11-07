package com.example.uday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uday.dao.UserDB;
import com.example.uday.pojo.UserInformation;

@Service
public class UserService {
	@Autowired
	private UserDB userDB;
	
	public UserInformation fetchUserInformation(long userMobileNumber) {
		return userDB.retrieveUser(userMobileNumber);
	}
	
	public void updateUser(UserInformation userInformation) {
		userDB.updateUser(userInformation);
	}
	
	public void deleteUser(long userId) {
		userDB.deleteUser(userId);
	}
	
	public UserInformation createUser(UserInformation userInformation) {
		userDB.addUser(userInformation);
		return userInformation;
	}
	
}
