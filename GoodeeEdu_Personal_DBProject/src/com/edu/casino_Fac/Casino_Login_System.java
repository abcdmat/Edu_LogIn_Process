package com.edu.casino_Fac;

import com.edu.Default_Page.ICasino_Interface;

public class Casino_Login_System implements RunSys {
	@Override
	public void runSys() {
		while(true){
		Casino_Delegator dele = new Casino_Delegator();
		Casino_Page_Factory fac = Casino_Page_Factory.getInstance();
		ICasino_Interface page = fac.factroy();
		dele.Casino_Process(page);
		}
	}
}
