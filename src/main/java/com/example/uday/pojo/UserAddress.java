package com.example.uday.pojo;

import java.util.List;
import com.example.uday.dao.pojo.Address;

public class UserAddress {

	private String userEmailId;
	private Long userMobileNumber;
	private String userName;
	private boolean isDisabled;
	private List<Address> userAddress;

	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public Long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isDisabled() {
		return isDisabled;
	}
	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
	public List<Address> getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(List<Address> userAddress) {
		this.userAddress = userAddress;
	}
}