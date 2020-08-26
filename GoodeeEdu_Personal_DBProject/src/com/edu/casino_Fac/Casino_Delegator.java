package com.edu.casino_Fac;

import com.edu.Default_Page.ICasino_Interface;

public class Casino_Delegator {
	public  void Casino_Process(ICasino_Interface page) {
		if(page ==null) {
			System.out.println("잘못된 명령입니다. 관리자에게 문의하세요");
		}else {
			page.run();
		}
	}
}
