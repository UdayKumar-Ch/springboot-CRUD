package com.example.uday.pojo;

public class UserInformation {

	private long userMobileNumber;
	private String userName;
	private String userEmailId;
	private String address;
	
	//	This property is set to false by default. 
	//	This is set to true if and only if user wants to deactivate his account. 
	private boolean isDisabled = false;

	public boolean isUserDisabled() {
		return this.isDisabled;
	}

	public void setIsUserDisabled(boolean isUserDisabled) {
		this.isDisabled = isUserDisabled;
	}

	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}