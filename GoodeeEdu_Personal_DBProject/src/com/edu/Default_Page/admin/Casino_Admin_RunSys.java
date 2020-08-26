package com.edu.Default_Page.admin;

import com.edu.Default_Page.ICasino_Interface;
import com.edu.Default_Page.user.Casino_User_Factory;
import com.edu.casino_Fac.Casino_Delegator;
import com.edu.casino_Fac.RunSys;
import com.edu.dto.Casino_Dto;

public class Casino_Admin_RunSys implements RunSys {
	@Override
	public void runSys() {
		while(true) {
			Casino_Delegator dele = new Casino_Delegator();
			Casino_Admin_Factory fac = Casino_Admin_Factory.getInstance();
			ICasino_Interface userPage = fac.factory();
			dele.Casino_Process(userPage);
		}
	}
}
