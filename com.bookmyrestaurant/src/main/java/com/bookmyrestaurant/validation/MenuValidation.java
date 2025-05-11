package com.bookmyrestaurant.validation;

public interface MenuValidation {

	public String validateMenuItem(String itemName, String itemDescription, double itemPrice, String itemCategory, String status);
	public String validateMenuItem(String itemName, String itemDescription, double itemPrice);
}
