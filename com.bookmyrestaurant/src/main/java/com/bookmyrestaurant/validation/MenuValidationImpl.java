package com.bookmyrestaurant.validation;

public class MenuValidationImpl implements MenuValidation {


	@Override
	public String validateMenuItem(String itemName, String itemDescription, double itemPrice, String itemCategory, String status) {
		int item_name_len=itemName.trim().length();
		int item_desc_len=itemDescription.length();
		String result;
		if( item_name_len  < 7 || item_name_len  > 30) {
			result="Invalid Item Name";
		}else if( item_desc_len < 20 || item_desc_len > 70) {
			result="Invalid Item Description";
		}else if(itemPrice<0) {
			result="Invalid Item Price";
		}else if(!status.equals("Success")) {
			result="Img Couldnt save";
		}else {
			result="Valid";
		}
		return result;
	}

	@Override
	public String validateMenuItem(String itemName, String itemDescription, double itemPrice) {
		int item_name_len=itemName.trim().length();
		int item_desc_len=itemDescription.length();
		String result;
		if( item_name_len  < 7 || item_name_len  > 30) {
			result="Invalid Item Name";
		}else if( item_desc_len < 20 || item_desc_len > 70) {
			result="Invalid Item Description";
		}else if(itemPrice<0) {
			result="Invalid Item Price";
		}else {
			result="Valid";
		}
		return result;
	}

}
