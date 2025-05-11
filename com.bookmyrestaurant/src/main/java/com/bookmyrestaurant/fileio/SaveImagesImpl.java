package com.bookmyrestaurant.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class SaveImagesImpl implements SaveImages {

	@Override
	public String saveMenuItemImages(Part itemImage,String path) {
		String imageName = itemImage.getSubmittedFileName();
		String fullPath=path+File.separator +imageName;	
		try {
		// Writing Opr path
//			System.out.println("this is path\n"+path);
			FileOutputStream fos=new FileOutputStream(fullPath);
			InputStream is=itemImage.getInputStream();
			
			//reading
			byte[] data=new byte[is.available()];
			is.read(data);
			System.out.println();
			
			fos.write(data);
			is.close();
			fos.close();			
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed";
		}
		
		return "Success";
	} 
}
