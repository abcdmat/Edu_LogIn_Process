package com.edu.Default_Page;

import com.edu.scan.Casino_Scan;

public class Casino_FindID_Page extends Casino_Page_Impl{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//아이디를 찾아서 아이디만 보여준다.
		//아이디는 이름과 이메일로 확인한다.
		
		while (true) {
			System.out.println("아이디 찾기 입니다. 이름과 이메일을 입력하여 아이디를 찾습니다.");
			String nAME = Casino_Scan.inputName();
			Casino_Scan.isEnd("아이디 찾기", nAME);
			String eMAIL = Casino_Scan.inputEmail();
			Casino_Scan.isEnd("아이디 찾기", eMAIL);
			String result = dao.findID(nAME, eMAIL);
			if (result.equals("null")) {
				System.out.println("해당하는 아이디가 없습니다.");
			}else {
			System.out.println("아이디는 【" + result + "】입니다.");
			break;
			}
		}	
	}

}
