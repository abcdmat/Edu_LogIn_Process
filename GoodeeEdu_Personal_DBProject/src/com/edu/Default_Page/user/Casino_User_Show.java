package com.edu.Default_Page.user;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_User_Show extends Casino_UserPage_Impl {

	public Casino_User_Show() {
		// TODO Auto-generated constructor stub
	}
	public Casino_User_Show(Casino_Dto dto) {
		// TODO Auto-generated constructor stub
		super.dto = dto;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("내 정보를 보여줍니다.");
			System.out.println(dto);
			break;
		}
	}
}
