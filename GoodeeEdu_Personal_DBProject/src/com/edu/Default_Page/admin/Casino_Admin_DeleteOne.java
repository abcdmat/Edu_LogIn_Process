package com.edu.Default_Page.admin;

import com.edu.scan.Casino_Scan;

public class Casino_Admin_DeleteOne extends Casino_AdminPage_Impl{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ȸ���� �����մϴ�. ȸ���� ������ȣ�� �Է����ּ���");
		while (true) {
			String seq = Casino_Scan.inputSeq();
			Casino_Scan.isEnd("ȸ������", seq);
			try {
				dao.delete(Integer.parseInt(seq));
				System.out.println("������ �����߽��ϴ�.");
				break;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("�߸��� ���Դϴ� �ٽ� �Է��� �ּ���");
			} 
		}
	}

}
