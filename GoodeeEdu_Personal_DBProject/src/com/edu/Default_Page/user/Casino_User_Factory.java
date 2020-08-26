package com.edu.Default_Page.user;

import com.edu.Default_Page.ICasino_Interface;
import com.edu.Default_Page.admin.Casino_Admin_DeleteOne;
import com.edu.Default_Page.admin.Casino_Admin_SelectAll;
import com.edu.Default_Page.admin.Casino_Admin_SelectOne;
import com.edu.Default_Page.admin.Casino_Admin_ShowFriend;
import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_User_Factory {
	private Casino_User_Factory() {}
	private static Casino_User_Factory instance;
	public static Casino_User_Factory getInstance() {
		if(instance ==null) {
			instance = new Casino_User_Factory();
		}
		return instance;
	}
	
	public ICasino_Interface factory() {
		ICasino_Interface userPage = null;
		

		String state = Casino_Scan.userPageController();
		if(state.equals("1") || state.equalsIgnoreCase("show")) {
			userPage= new Casino_User_Show();
		}else if(state.equals("2") || state.equalsIgnoreCase("chpw")) {
			userPage= new Casino_User_Change_pW();
		}else if(state.equals("3") || state.equalsIgnoreCase("chemail")) {
			userPage= new Casino_User_Change_Email();
		}else if(state.equals("4") || state.equalsIgnoreCase("chphi")) {
			userPage= new Casino_User_Change_Phone();
		}
		
		return userPage;
	}
	public ICasino_Interface factory(Casino_Dto dto) {
		ICasino_Interface userPage = null;
		

		String state = Casino_Scan.userPageController();
		if(state.equals("1") || state.equalsIgnoreCase("show")) {
			userPage= new Casino_User_Show(dto);
		}else if(state.equals("2") || state.equalsIgnoreCase("chpw")) {
			userPage= new Casino_User_Change_pW(dto);
		}else if(state.equals("3") || state.equalsIgnoreCase("chemail")) {
			userPage= new Casino_User_Change_Email(dto);
		}else if(state.equals("4") || state.equalsIgnoreCase("chphi")) {
			userPage= new Casino_User_Change_Phone(dto);
		}
		
		return userPage;
	}
	
}
