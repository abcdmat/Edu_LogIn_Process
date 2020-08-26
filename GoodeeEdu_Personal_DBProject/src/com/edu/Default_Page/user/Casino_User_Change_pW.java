package com.edu.Default_Page.user;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_User_Change_pW extends Casino_UserPage_Impl {

	public Casino_User_Change_pW() {
		// TODO Auto-generated constructor stub
	}
	public Casino_User_Change_pW(Casino_Dto dto) {
		// TODO Auto-generated constructor stub
		super.dto = dto;
	}
	
	@Override
	public void run() {
		do {
			// TODO Auto-generated method stub
			System.out.println("비밀번호를 변경합니다.");
			String pW = Casino_Scan.inputPW();
			Casino_Scan.isEndUser("유저 비밀번호 변경", pW);
			if(! dao.updatepW(pW, dto.getID())) {
				System.out.println("업데이트를 완료했습니다.");
				break;
			}
		} while (true);
		
	}

}
