package com.edu.casino_Fac;

import com.edu.Default_Page.ICasino_Interface;

public class Casino_Delegator {
	public  void Casino_Process(ICasino_Interface page) {
		if(page ==null) {
			System.out.println("�߸��� ����Դϴ�. �����ڿ��� �����ϼ���");
		}else {
			page.run();
		}
	}
}
