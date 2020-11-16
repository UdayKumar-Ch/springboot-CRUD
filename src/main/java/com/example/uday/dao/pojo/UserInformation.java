package com.example.uday.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class UserInformation {
	
	@Id
	@Column(name="email_id")
	private String userEmailId;

	@Column(name="mobile_number")
	private Long userMobileNumber;
	
	@Column(name = "user_name")
	private String userName;
		
	//	This property is set to false by default. 
	//	This is set to true if and only if user wants to deactivate his account. 
	@Column(name="is_account_disabled")
	private boolean isDisabled = false;

	public boolean isUserDisabled() {
		return this.isDisabled;
	}

	public void setIsUserDisabled(boolean isUserDisabled) {
		this.isDisabled = isUserDisabled;
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
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
}