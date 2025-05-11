	package com.bookmyrestaurant.validation;

public class AdminValidationImpl implements AdminValidation {
	private String adminStatus;
	@Override
	public String adminLoginValidation(String username, String password) {
		System.out.println("LOG: inside AdminValidation->adminLoginValidation");		
		try {
			if(username.length()< 5 || username.length() >15 ) {			
				adminStatus="INVALID USERNAME";
			}else if(password.length() < 7 || password.length() > 15){				
				adminStatus="INVALID PASSWORD";
			}else {
				adminStatus="VALID";
			}
		} catch (Exception e) {
			adminStatus="SOMTHING WENT WRONG";
			e.printStackTrace();
		}
		System.out.println("LOG: inside AdminValidation->adminLoginValidation-> User Validation Complete");
		return adminStatus;
	}

}
