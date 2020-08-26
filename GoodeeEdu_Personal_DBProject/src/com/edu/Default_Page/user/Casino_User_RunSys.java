package com.edu.Default_Page.user;

import com.edu.Default_Page.ICasino_Interface;
import com.edu.casino_Fac.Casino_Delegator;
import com.edu.casino_Fac.RunSys;
import com.edu.dto.Casino_Dto;

public class Casino_User_RunSys  implements RunSys {
	@Override
	public void runSys() {
		runSys(new Casino_Dto());
	}
	
	public void runSys(Casino_Dto dto) {
		while(true) {
		Casino_Delegator dele = new Casino_Delegator();
		Casino_User_Factory fac = Casino_User_Factory.getInstance();
		ICasino_Interface userPage = fac.factory(dto);
		dele.Casino_Process(userPage);
		}
	}
}
