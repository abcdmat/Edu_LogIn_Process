package com.edu.Default_Page.user;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_User_Change_Phone extends Casino_UserPage_Impl {
	public Casino_User_Change_Phone() {
		// TODO Auto-generated constructor stub
	}
	public Casino_User_Change_Phone(Casino_Dto dto) {
		// TODO Auto-generated constructor stub
		super.dto = dto;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			// TODO Auto-generated method stub
			System.out.println("��ȭ��ȣ�� �����մϴ�.");
			String phone = Casino_Scan.inputPhone();
			Casino_Scan.isEndUser("���� ��ȭ��ȣ ����", phone);
			if(! dao.updatepW(phone, dto.getID())) {
				System.out.println("������Ʈ�� �Ϸ��߽��ϴ�.");
				break;
			}
		} while (true);
		
	}

}
