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
			System.out.println("이메일을 변경합니다.");
			String email = Casino_Scan.inputEmail();
			Casino_Scan.isEndUser("유저 이메일 변경", email);
			if(! dao.updatepW(email, dto.getID())) {
				System.out.println("업데이트를 완료했습니다.");
				break;
			}
		} while (true);
	}

}
