package com.edu.Default_Page;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_SignIn_Page extends Casino_Page_Impl {

	public Casino_SignIn_Page() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * ȸ�����Խ� ���� ���� JOB FLAG�� ����Ʈ ������ �Էµǵ��� �����ؾ��Ѵ�. ����Ʈ ���� 'P'�� �÷��̾ ��Ÿ����. ģ�� ID �Է½�
	 * ģ������ 500�� �Ӵ� ����( ģ�����̵� ������ ���ٰ� ������ �϶�) ȸ�������Ҷ� ID ,PW, NAME, PHONE, EMAIL +
	 * ģ�����̵� �����Է� ID�� �Է������� �ߺ�ó�� �����ϰ�
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String iD = null;
		do {
			do {
				iD = Casino_Scan.inputID();
				Casino_Scan.isEnd("ȸ������", iD);
			} while (dao.checkID_SignIn(iD));
			String pW = Casino_Scan.inputPW();
			Casino_Scan.isEnd("ȸ������", pW);
			String nAME = Casino_Scan.inputName();
			Casino_Scan.isEnd("ȸ������", nAME);
			String eMAIL;
			do {
				eMAIL = Casino_Scan.inputEmail();
				Casino_Scan.isEnd("ȸ������", eMAIL);
			} while (dao.checkEmail(eMAIL));
			String pHONE = null;
			do {
				pHONE = Casino_Scan.inputPhone();
				Casino_Scan.isEnd("ȸ������", pHONE);
			} while (dao.checkPhone(pHONE));
			String fId = null;
			System.out.println("��õ�� ���̵� �Է� �Ͻðڽ��ϱ�?");
			if (Casino_Scan.yesorno()) {
				System.out.println("ģ�� ���̵� �Է��� �ּ���");
				do {
					fId = Casino_Scan.inputID();
					Casino_Scan.isEnd("ȸ������", fId);
				} while (dao.checkFID(fId));
			} else {
				fId = "null";
			} 
			dto = new Casino_Dto(iD, pW, nAME, pHONE, eMAIL, fId);
		} while (dao.signIn(dto));
		System.out.println("ȸ�������� �Ϸ� �߽��ϴ�. �α����� �ּ���");
		
	}

}
