package com.edu.Default_Page;

import com.edu.Default_Page.admin.Casino_Admin_RunSys;
import com.edu.Default_Page.user.Casino_User_RunSys;
import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_Login_Page extends Casino_Page_Impl {

	public Casino_Login_Page() {
		// TODO Auto-generated constructor sturb
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 로그인에 관련된 로직 생성
		String iD = null;
		String pW = null;
		// 로그인이 성공할때까지 계속해서 돌린다.

		while (true) {
			// 아이디를 한번 칠때마다 중복 검사를 해서 수고를 줄여보자
			do {
				iD = Casino_Scan.inputID();
				Casino_Scan.isEnd("로그인", iD);

			} while (dao.checkID(iD));
			pW = Casino_Scan.inputPW();
			Casino_Scan.isEnd("로그인", pW);
			dto = new Casino_Dto(iD, pW);
			dto = dao.login(dto);
			if (dto == null) { //로그인 실패시
				threadtimer();
				System.err.println("...잘못된 비밀번호입니다.");
				threadtimer();
			} else {
				break;
				
			} 
		}
		drawSomething();
		switch (dto.getJOB()) {
		case "P":
			System.out.println("유저 로그인 성공!");
			Casino_User_RunSys userRun = new Casino_User_RunSys();
			userRun.runSys(dto);
			break;
		case "A":
		System.out.println("어드민 로그인 성공!");
		Casino_Admin_RunSys admin = new Casino_Admin_RunSys();
		admin.runSys();
			break;
		}
		
		
	}
	private void threadtimer() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private void drawSomething() {
		try {
			System.out.println();
			System.out.println("　　　　　.........");
			Thread.sleep(300);
			System.out.println("　　　　　 .......");
			Thread.sleep(300);
			System.out.println("　　　　　  .....");
			Thread.sleep(300);
			System.out.println("　　　　　   ...");
			Thread.sleep(300);
			System.out.println("　　　　　    .");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
