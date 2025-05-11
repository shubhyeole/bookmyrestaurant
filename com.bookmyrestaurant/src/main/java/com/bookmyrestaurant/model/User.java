package com.bookmyrestaurant.model;

public class User {

	private int srNo;
	private String name;
	private String email;
	private String subject;
	private String message;
	private String dateTime;
	
	
	
	
	
	
	public User() {
		super();
	}
	public User(int srNo, String name, String email, String subject, String message, String dateTime) {
		super();
		this.srNo = srNo;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.dateTime = dateTime;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
