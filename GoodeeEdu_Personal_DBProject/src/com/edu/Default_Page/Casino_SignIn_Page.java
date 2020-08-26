package com.edu.Default_Page;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_SignIn_Page extends Casino_Page_Impl {

	public Casino_SignIn_Page() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 회원가입시 가장 뒤의 JOB FLAG를 디폴트 값으로 입력되도록 생성해야한다. 디폴트 값은 'P'로 플레이어를 나타낸다. 친구 ID 입력시
	 * 친구에게 500의 머니 증정( 친구아이디가 없으면 없다고 나오게 하라) 회원가입할때 ID ,PW, NAME, PHONE, EMAIL +
	 * 친구아이디 선택입력 ID만 입력했을때 중복처리 가능하게
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String iD = null;
		do {
			do {
				iD = Casino_Scan.inputID();
				Casino_Scan.isEnd("회원가입", iD);
			} while (dao.checkID_SignIn(iD));
			String pW = Casino_Scan.inputPW();
			Casino_Scan.isEnd("회원가입", pW);
			String nAME = Casino_Scan.inputName();
			Casino_Scan.isEnd("회원가입", nAME);
			String eMAIL;
			do {
				eMAIL = Casino_Scan.inputEmail();
				Casino_Scan.isEnd("회원가입", eMAIL);
			} while (dao.checkEmail(eMAIL));
			String pHONE = null;
			do {
				pHONE = Casino_Scan.inputPhone();
				Casino_Scan.isEnd("회원가입", pHONE);
			} while (dao.checkPhone(pHONE));
			String fId = null;
			System.out.println("추천인 아이디를 입력 하시겠습니까?");
			if (Casino_Scan.yesorno()) {
				System.out.println("친구 아이디를 입력해 주세요");
				do {
					fId = Casino_Scan.inputID();
					Casino_Scan.isEnd("회원가입", fId);
				} while (dao.checkFID(fId));
			} else {
				fId = "null";
			} 
			dto = new Casino_Dto(iD, pW, nAME, pHONE, eMAIL, fId);
		} while (dao.signIn(dto));
		System.out.println("회원가입을 완료 했습니다. 로그인해 주세요");
		
	}

}
