package com.bookmyrestaurant.validation;

public class ServiceModuleValidationImpl implements ServiceModuleValidation {

	@Override
	public String validateServiceModule(String iconName, String title, String description) {
		int icon_name_len = iconName.length();
		int title_len = title.length();
		int description_len = description.length();
		String result;
		if (icon_name_len < 4 || icon_name_len > 50) {
			result = "INVALID ICON NAME";
		} else if (title_len < 5 || title_len > 20) {
			result = "INVALID TITLE";
		} else if (description_len < 10 || description_len > 70) {
			result = "INVALID DESCRIPTION";
		} else {
			result = "VALID";
		}
		return result;

	}

}
