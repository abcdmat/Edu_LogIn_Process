package com.edu.Default_Page;

import com.edu.dto.Casino_Dto;
import com.edu.scan.Casino_Scan;

public class Casino_FindPW_Page extends Casino_Page_Impl {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("��й�ȣ ã�� �Դϴ�. ���̴ٿ� �̸����� �Է��Ͽ� ��й�ȣ�� ã���ϴ�.");
			String nAME = Casino_Scan.inputID();
			Casino_Scan.isEnd("��й�ȣ ã��", nAME);
			String eMAIL = Casino_Scan.inputEmail();
			Casino_Scan.isEnd("��й�ȣ ã��", eMAIL);
			Casino_Dto result = dao.findPW(nAME, eMAIL);
			if (result.equals("null")) {
				System.out.println("�ش��ϴ� ���̵� �����ϴ�.");
			}else {
			System.out.println("  ���̵� ��" + result.getID() + "���Դϴ�.");
			System.out.println("��й�ȣ ��" + result.getPW() + "���Դϴ�.");
			break;
			}
		}	
	}

}
