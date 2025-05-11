package com.bookmyrestaurant.fileio;

import javax.servlet.http.Part;

public interface SaveImages {
	public String saveMenuItemImages(Part itemImage,String path);
}
