package com.edu.Default_Page.admin;

import com.edu.scan.Casino_Scan;

public class Casino_Admin_SelectOne extends Casino_AdminPage_Impl {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//아이디로? 하나를 검색한다.
		while (true) {
			System.out.println("아이디 찾기 입니다. 아이디를 입력하여 아이디를 찾습니다.");
			String iD = Casino_Scan.inputName();
			Casino_Scan.isEnd("회원 찾기", iD);

			dto = dao.findID(iD);
			if (dto == null) {
				System.out.println("해당하는 아이디가 없습니다.");
			}else {
				System.out.println(dto);
			break;
			}
		}	
		
	}

}
