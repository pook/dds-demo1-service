package com.aec.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements java.io.Serializable{


	private static final long serialVersionUID = -5795849058225676687L;

	@JsonProperty("USER_ID")	
	public int userId = 0;
	
	@JsonProperty("USER_FNAME")	
    public String userFname= ""; /* maximum length = (255) */
    
    @JsonProperty("USER_LNAME")	
    public String userLName= ""; /* maximum length = (255) */
    
    @JsonProperty("AGE")	
    public int age = 0;
    
    @JsonProperty("ADDRESS")	
    public String address= "";

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	} 
}
