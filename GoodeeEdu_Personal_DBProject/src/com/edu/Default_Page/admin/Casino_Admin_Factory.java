package com.edu.Default_Page.admin;

import com.edu.Default_Page.ICasino_Interface;
import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_Admin_Factory {
	private Casino_Admin_Factory() {}
	private static Casino_Admin_Factory instance;
	public static Casino_Admin_Factory getInstance() {
		if(instance == null) {
			instance = new Casino_Admin_Factory();
		}
		return instance;
	}
	public ICasino_Interface factory() {
		ICasino_Interface adminPage = null;
		
		String state = Casino_Scan.adminPageController();
		if(state.equals("1") || state.equalsIgnoreCase("selectone")) {
			adminPage= new Casino_Admin_SelectOne();
		}else if(state.equals("2") || state.equalsIgnoreCase("selectall")) {
			adminPage= new Casino_Admin_SelectAll();
		}else if(state.equals("3") || state.equalsIgnoreCase("del")) {
			adminPage= new Casino_Admin_DeleteOne();
		}else if(state.equals("4") || state.equalsIgnoreCase("showfri")) {
			adminPage= new Casino_Admin_ShowFriend();
		}

		
		return adminPage;
	}
	public ICasino_Interface factory(Casino_Dto dto) {
		ICasino_Interface adminPage = null;
		
		String state = Casino_Scan.adminPageController();
		if(state.equals("1") || state.equalsIgnoreCase("selectone")) {
			adminPage= new Casino_Admin_SelectOne();
		}else if(state.equals("2") || state.equalsIgnoreCase("selectall")) {
			adminPage= new Casino_Admin_SelectAll();
		}else if(state.equals("3") || state.equalsIgnoreCase("del")) {
			adminPage= new Casino_Admin_DeleteOne();
		}else if(state.equals("4") || state.equalsIgnoreCase("showfri")) {
			adminPage= new Casino_Admin_ShowFriend();
		}

		
		return adminPage;
	}
}
