package com.edu.Default_Page.user;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_User_Change_Email extends Casino_UserPage_Impl {

	public Casino_User_Change_Email() {
		// TODO Auto-generated constructor stub
	}
	public Casino_User_Change_Email(Casino_Dto dto) {
		// TODO Auto-generated constructor stub
		super.dto = dto;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			// TODO Auto-generated method stub
			System.out.println("�̸����� �����մϴ�.");
			String email = Casino_Scan.inputEmail();
			Casino_Scan.isEndUser("���� �̸��� ����", email);
			if(! dao.updatepW(email, dto.getID())) {
				System.out.println("������Ʈ�� �Ϸ��߽��ϴ�.");
				break;
			}
		} while (true);
	}

}
