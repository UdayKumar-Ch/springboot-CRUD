package com.example.uday.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uday.dao.AddressDB;
import com.example.uday.dao.UserInformationDB;
import com.example.uday.exception.UserNotFoundException;
import com.example.uday.pojo.Address;
import com.example.uday.pojo.UserInformation;
import com.google.common.base.Strings;

@Service
public class UserService {

	@Autowired
	private UserInformationDB userInformationDB;

	@Autowired 
	private AddressDB addressDB;

	public List<Address> getAddressByUserEmailId(String emailId){
		return addressDB.findByAddressEmailId(emailId);
	}

	public UserInformation createNewUser(UserInformation userInformation) {
		return userInformationDB.save(userInformation);
	}
	
	public Address addAddressToUser(Address address, String emailId) {
		return userInformationDB.findById(emailId).map(
				user -> {
					address.setUser(user);
					return addressDB.save(address);
				}).orElseThrow(() -> new UserNotFoundException("User not exists:"+ emailId));
	}

	public UserInformation getUserInformation(String userEmailId) {
		//	Throws EntityNotFoundException If EmailId (user) not available...
		return  userInformationDB.findById(userEmailId).map(
				user -> {
					return user;
				}).orElseThrow(()-> new UserNotFoundException("User Not found : "+userEmailId));
		
		
	}

	public UserInformation updateUserInformation(UserInformation userInformation) {
		return userInformationDB.findById(userInformation.getUserEmailId()).map(
				user -> {
					if (userInformation.getUserMobileNumber()!= null && userInformation.getUserMobileNumber() != 0l) {
						user.setUserMobileNumber(userInformation.getUserMobileNumber());
						return userInformationDB.save(user);
					}
					return user;
				}).orElseThrow(() -> new UserNotFoundException("User not exists:"+ userInformation.getUserEmailId()));
	}

	public Address updateAddressByAddressId(Address toModifyAddress) {
		Address existingAddress = addressDB.getOne(toModifyAddress.getAddressId());

		if  (!Strings.isNullOrEmpty(toModifyAddress.getLine1())) {
			existingAddress.setLine1(toModifyAddress.getLine1());
		}
		if  (!Strings.isNullOrEmpty(toModifyAddress.getLine2())) {
			existingAddress.setLine1(toModifyAddress.getLine2());
		}
		if  (!Strings.isNullOrEmpty(toModifyAddress.getLine3())) {
			existingAddress.setLine1(toModifyAddress.getLine3());
		}
		if  (!Strings.isNullOrEmpty(toModifyAddress.getCity())) {
			existingAddress.setLine1(toModifyAddress.getCity());
		}
		if  (!Strings.isNullOrEmpty(toModifyAddress.getCountry())) {
			existingAddress.setLine1(toModifyAddress.getCountry());
		}
		if  (!Strings.isNullOrEmpty(toModifyAddress.getStateProvince())) {
			existingAddress.setLine1(toModifyAddress.getStateProvince());
		}
		if  (!Strings.isNullOrEmpty(toModifyAddress.getPostalCode())) {
			existingAddress.setLine1(toModifyAddress.getPostalCode());
		}

		return addressDB.save(existingAddress);
	}

	public boolean deleteAddressById(Long addressId) {
		addressDB.deleteById(addressId);
		return true;
	}

	public boolean deleteAddress(Address toBeDeletedAddress) {
		addressDB.deleteById(toBeDeletedAddress.getAddressId());
		return true;
	}
	
	public UserInformation disableUser(UserInformation userInformation) {
		return userInformationDB.findById(userInformation.getUserEmailId()).map(
				user -> {
					user.setIsUserDisabled(true);
					return userInformationDB.save(user);
				}).orElseThrow(() -> new UserNotFoundException("User not exists:"+ userInformation.getUserEmailId()));
	}
	
	

	public UserInformation disableUser(String userId) {
		return userInformationDB.findById(userId).map(
				user -> {
					user.setIsUserDisabled(true);
					return userInformationDB.save(user);
				}).orElseThrow(() -> new UserNotFoundException("User not exists:"+ userId));
	}

	public void deleteUser(UserInformation userInformation) {
		userInformationDB.delete(userInformation);
	}
	
	

	public void deleteUser(String userId) {
		userInformationDB.deleteById(userId);
	}
	
}
