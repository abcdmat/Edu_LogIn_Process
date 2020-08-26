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
		// �α��ο� ���õ� ���� ����
		String iD = null;
		String pW = null;
		// �α����� �����Ҷ����� ����ؼ� ������.

		while (true) {
			// ���̵� �ѹ� ĥ������ �ߺ� �˻縦 �ؼ� ���� �ٿ�����
			do {
				iD = Casino_Scan.inputID();
				Casino_Scan.isEnd("�α���", iD);

			} while (dao.checkID(iD));
			pW = Casino_Scan.inputPW();
			Casino_Scan.isEnd("�α���", pW);
			dto = new Casino_Dto(iD, pW);
			dto = dao.login(dto);
			if (dto == null) { //�α��� ���н�
				threadtimer();
				System.err.println("...�߸��� ��й�ȣ�Դϴ�.");
				threadtimer();
			} else {
				break;
				
			} 
		}
		drawSomething();
		switch (dto.getJOB()) {
		case "P":
			System.out.println("���� �α��� ����!");
			Casino_User_RunSys userRun = new Casino_User_RunSys();
			userRun.runSys(dto);
			break;
		case "A":
		System.out.println("���� �α��� ����!");
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
			System.out.println("����������.........");
			Thread.sleep(300);
			System.out.println("���������� .......");
			Thread.sleep(300);
			System.out.println("����������  .....");
			Thread.sleep(300);
			System.out.println("����������   ...");
			Thread.sleep(300);
			System.out.println("����������    .");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
