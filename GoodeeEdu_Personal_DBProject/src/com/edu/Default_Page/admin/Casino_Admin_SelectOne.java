package com.edu.Default_Page.admin;

import com.edu.scan.Casino_Scan;

public class Casino_Admin_SelectOne extends Casino_AdminPage_Impl {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//���̵��? �ϳ��� �˻��Ѵ�.
		while (true) {
			System.out.println("���̵� ã�� �Դϴ�. ���̵� �Է��Ͽ� ���̵� ã���ϴ�.");
			String iD = Casino_Scan.inputName();
			Casino_Scan.isEnd("ȸ�� ã��", iD);

			dto = dao.findID(iD);
			if (dto == null) {
				System.out.println("�ش��ϴ� ���̵� �����ϴ�.");
			}else {
				System.out.println(dto);
			break;
			}
		}	
		
	}

}
