package com.example.uday.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.uday.dao.AddressDB;
import com.example.uday.dao.UserInformationDB;
import com.example.uday.dao.pojo.Address;
import com.example.uday.dao.pojo.UserInformation;
import com.example.uday.exception.UserAlreadyExistedException;
import com.example.uday.exception.UserNotFoundException;
import com.example.uday.pojo.UserAddress;

@Service
public class UserService {

	private static final String USER_NOT_FOUND = "User Not found : ";

	private static final String USER_NOT_EXISTS = "User not exists:";

	private static final String EMAIL_ID_ALREADY_USED = "Email Id Already Used";

	private static final String USER_NOT_EXISTED_RE_CHECK = "User not existed. Please re-check user name";

	@Autowired
	private UserInformationDB userInformationDB;

	@Autowired 
	private AddressDB addressDB;

	public List<Address> getAddressByUserEmailId(String emailId){
		return addressDB.findByAddressEmailId(emailId);
	}

	public UserInformation createNewUser(UserInformation userInformation) {
		if (userInformationDB.findById(userInformation.getUserEmailId()).isEmpty()) {
			return userInformationDB.save(userInformation);
		}else {
			throw new UserAlreadyExistedException(EMAIL_ID_ALREADY_USED);
		}
	}

	public Address addAddressToUser(Address address, String emailId) {
		return userInformationDB.findById(emailId).map(
				user -> {
					address.setUser(user);
					return addressDB.save(address);
				}).orElseThrow(() -> new UserNotFoundException(USER_NOT_EXISTS+ emailId));
	}

	public UserAddress getUserInformation(String userEmailId) {
		//	Throws EntityNotFoundException If EmailId (user) not available...
		return  userInformationDB.findById(userEmailId).map(
				user -> {
					UserAddress usad = new UserAddress();
					usad.setDisabled(user.isUserDisabled());
					usad.setUserEmailId(userEmailId);
					usad.setUserMobileNumber(user.getUserMobileNumber());
					usad.setUserName(user.getUserName());
					usad.setUserAddress(addressDB.findByAddressEmailId(userEmailId));
					return usad;
				}).orElseThrow(()-> new UserNotFoundException(USER_NOT_FOUND+userEmailId));


	}

	public UserInformation updateUserInformation(UserInformation userInformation) {
		return userInformationDB.findById(userInformation.getUserEmailId()).map(
				user -> {
					if (userInformation.getUserMobileNumber()!= null && userInformation.getUserMobileNumber() != 0l) {
						user.setUserMobileNumber(userInformation.getUserMobileNumber());
						return userInformationDB.save(user);
					}
					return user;
				}).orElseThrow(() -> new UserNotFoundException(USER_NOT_EXISTS+ userInformation.getUserEmailId()));
	}

	public Address updateAddressByAddressId(Address toModifyAddress) {
		return addressDB.save(toModifyAddress);
	}

	public boolean deleteAddressById(Long addressId) {
		addressDB.deleteById(addressId);
		return true;
	}

	public UserInformation disableUser(UserInformation userInformation) {
		return userInformationDB.findById(userInformation.getUserEmailId()).map(
				user -> {
					user.setIsUserDisabled(true);
					return userInformationDB.save(user);
				}).orElseThrow(() -> new UserNotFoundException(USER_NOT_EXISTS+ userInformation.getUserEmailId()));
	}

	public void deleteUser(String userId) {
		try {
			List<Address> allAddress = getAddressByUserEmailId(userId);
			addressDB.deleteAll(allAddress);
			userInformationDB.deleteById(userId);
		}catch (EmptyResultDataAccessException erdae) {
			throw new UserNotFoundException(USER_NOT_EXISTED_RE_CHECK);
		}
	}

}
