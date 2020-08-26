package com.edu.casino_Fac;


import com.edu.Default_Page.Casino_FindID_Page;
import com.edu.Default_Page.Casino_FindPW_Page;
import com.edu.Default_Page.Casino_Login_Page;
import com.edu.Default_Page.Casino_SignIn_Page;
import com.edu.Default_Page.ICasino_Interface;

import com.edu.scan.Casino_Scan;
import com.edu.scan.LoginState;

public class Casino_Page_Factory implements LoginState {

	private Casino_Page_Factory() {
	};
	private static Casino_Page_Factory instance;
	public static Casino_Page_Factory getInstance() {
		if(instance == null) {
			instance = new Casino_Page_Factory();
		}
		return instance; 
	}
	public ICasino_Interface factroy() {
		ICasino_Interface fac = null;

		//로그인이면 로그인을 다 한 후 유저인지 어드민인지 확인하는 작업을 할것임
		// 여기서 나오는 값에 따라 할 일을 정한다.
		//작업 핸들링은 1. 로그인, 2 회원가입, 3.아이디 찾기, 4.비밀번호 찾기로 구성한다.
		// 로그인후 작업은 
		//  사용자는 1. 체인지 패스워드, 2.이메일, 3. 폰 4. 내 정보 모두 보기 로 구성한다.
		//  운영자는 1. 딜리트 아이디, 2.  아이디 검색, 3. 모든 아이디 검색 , 4.아이디와 친구아이디 로 구성한다.
		String state = Casino_Scan.FristPageController();
		if(state.equals("1") || state.equalsIgnoreCase("login")) {
			fac= new Casino_Login_Page();
		}else if(state.equals("2") || state.equalsIgnoreCase("signin")) {
			fac= new Casino_SignIn_Page();
		}else if(state.equals("3") || state.equalsIgnoreCase("findid")) {
			fac= new Casino_FindID_Page();
		}else if(state.equals("4") || state.equalsIgnoreCase("findpw")) {
			fac= new Casino_FindPW_Page();
		}



		return fac;

	}
	

}
