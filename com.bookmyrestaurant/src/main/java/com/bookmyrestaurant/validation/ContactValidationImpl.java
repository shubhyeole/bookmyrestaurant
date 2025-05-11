package com.bookmyrestaurant.validation;

public class ContactValidationImpl implements ContactValidation {
String result;
	@Override
	public String validateContactData(String name, String email, String subject, String message) {
		
		int name_len=name.length();
		int email_len=email.length();
		
		if(name_len <10 | name_len>50) {
			result="INVALID NAME";
		}else if(email_len>50 || email_len<10 || !email.contains("@") || !email.endsWith(".com")) {
			result="INVALID EMAIL";
		}else {
			result="VALID";
		}
		return result;
	}
	

}
