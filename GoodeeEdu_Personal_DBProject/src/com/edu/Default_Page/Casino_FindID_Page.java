package com.edu.Default_Page;

import com.edu.scan.Casino_Scan;

public class Casino_FindID_Page extends Casino_Page_Impl{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//���̵� ã�Ƽ� ���̵� �����ش�.
		//���̵�� �̸��� �̸��Ϸ� Ȯ���Ѵ�.
		
		while (true) {
			System.out.println("���̵� ã�� �Դϴ�. �̸��� �̸����� �Է��Ͽ� ���̵� ã���ϴ�.");
			String nAME = Casino_Scan.inputName();
			Casino_Scan.isEnd("���̵� ã��", nAME);
			String eMAIL = Casino_Scan.inputEmail();
			Casino_Scan.isEnd("���̵� ã��", eMAIL);
			String result = dao.findID(nAME, eMAIL);
			if (result.equals("null")) {
				System.out.println("�ش��ϴ� ���̵� �����ϴ�.");
			}else {
			System.out.println("���̵�� ��" + result + "���Դϴ�.");
			break;
			}
		}	
	}

}
