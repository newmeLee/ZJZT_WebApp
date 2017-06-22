package com.zjzt.bean;

public class UserHealthInfoForJson {
	private boolean status;
	private String message;
	private UserHealthInfo userHealthInfo;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserHealthInfo getUserHealthInfo() {
		return userHealthInfo;
	}
	public void setUserHealthInfo(UserHealthInfo userHealthInfo) {
		this.userHealthInfo = userHealthInfo;
	}
}
