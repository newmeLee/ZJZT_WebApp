package com.zjzt.bean;

public class UserHealthInfo {
	private String name;
	private String phone;
	private String gender;//性别
	private int age;//年龄
	private double height;//身高
	private double weight;//体重
	private double diaBloodPress;//舒张压
	private double sysBloodPress;//收缩压
	private int cardiacRate;//心率
	public String sickHistory;//疾病史
	public String allergyHistory;//过敏史
	public String operationHistory;//手术史
	public String userHabit;//用户个人习惯
	public double getDiaBloodPress() {
		return diaBloodPress;
	}
	public void setDiaBloodPress(double diaBloodPress) {
		this.diaBloodPress = diaBloodPress;
	}
	public double getSysBloodPress() {
		return sysBloodPress;
	}
	public void setSysBloodPress(double sysBloodPress) {
		this.sysBloodPress = sysBloodPress;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCardiacRate() {
		return cardiacRate;
	}
	public void setCardiacRate(int cardiacRate) {
		this.cardiacRate = cardiacRate;
	}
	public String getSickHistory() {
		return sickHistory;
	}
	public void setSickHistory(String sickHistory) {
		this.sickHistory = sickHistory;
	}
	public String getAllergyHistory() {
		return allergyHistory;
	}
	public void setAllergyHistory(String allergyHistory) {
		this.allergyHistory = allergyHistory;
	}
	public String getOperationHistory() {
		return operationHistory;
	}
	public void setOperationHistory(String operationHistory) {
		this.operationHistory = operationHistory;
	}
	public String getUserHabit() {
		return userHabit;
	}
	public void setUserHabit(String userHabit) {
		this.userHabit = userHabit;
	}
}
