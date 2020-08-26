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

		//�α����̸� �α����� �� �� �� �������� �������� Ȯ���ϴ� �۾��� �Ұ���
		// ���⼭ ������ ���� ���� �� ���� ���Ѵ�.
		//�۾� �ڵ鸵�� 1. �α���, 2 ȸ������, 3.���̵� ã��, 4.��й�ȣ ã��� �����Ѵ�.
		// �α����� �۾��� 
		//  ����ڴ� 1. ü���� �н�����, 2.�̸���, 3. �� 4. �� ���� ��� ���� �� �����Ѵ�.
		//  ��ڴ� 1. ����Ʈ ���̵�, 2.  ���̵� �˻�, 3. ��� ���̵� �˻� , 4.���̵�� ģ�����̵� �� �����Ѵ�.
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
