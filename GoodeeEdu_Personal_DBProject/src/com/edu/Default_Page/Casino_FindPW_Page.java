package com.edu.Default_Page;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_FindPW_Page extends Casino_Page_Impl {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("비밀번호 찾기 입니다. 아이다와 이메일을 입력하여 비밀번호를 찾습니다.");
			String nAME = Casino_Scan.inputID();
			Casino_Scan.isEnd("비밀번호 찾기", nAME);
			String eMAIL = Casino_Scan.inputEmail();
			Casino_Scan.isEnd("비밀번호 찾기", eMAIL);
			Casino_Dto result = dao.findPW(nAME, eMAIL);
			if (result.equals("null")) {
				System.out.println("해당하는 아이디가 없습니다.");
			}else {
			System.out.println("  아이디 【" + result.getID() + "】입니다.");
			System.out.println("비밀번호 【" + result.getPW() + "】입니다.");
			break;
			}
		}	
	}

}
