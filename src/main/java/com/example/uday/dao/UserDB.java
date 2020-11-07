package com.example.uday.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.uday.pojo.UserInformation;
import com.google.common.base.Strings;

@Repository
public class UserDB {

	private static final Map<Long, UserInformation> userInformationStorage = new HashMap<Long, UserInformation>();

	public long addUser(UserInformation uinfo) {
		userInformationStorage.put(uinfo.getUserMobileNumber(), uinfo);
		return uinfo.getUserMobileNumber();
	}
	
	public UserInformation retrieveUser(long userMobileNumber) {
		return userInformationStorage.get(userMobileNumber);
	}
	
	public void updateUser(UserInformation uinforInformation) {
		UserInformation existedUserInformation = userInformationStorage.get(uinforInformation.getUserMobileNumber());
		if (Strings.isNullOrEmpty(uinforInformation.getAddress())) {
				existedUserInformation.setAddress(uinforInformation.getAddress());
		}
		if (Strings.isNullOrEmpty(uinforInformation.getUserEmailId())) {
			existedUserInformation.setUserEmailId(uinforInformation.getUserEmailId());
		}

	}
	
	public void deleteUser(long userMobileNumber) {
		UserInformation userInformation = userInformationStorage.get(userMobileNumber); 
		userInformation.setIsUserDisabled(true);
		userInformationStorage.put(userMobileNumber, userInformation);
	}
	
}

