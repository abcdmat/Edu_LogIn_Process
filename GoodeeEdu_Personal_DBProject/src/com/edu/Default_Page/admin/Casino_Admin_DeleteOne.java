package com.edu.Default_Page.admin;

import com.edu.scan.Casino_Scan;

public class Casino_Admin_DeleteOne extends Casino_AdminPage_Impl{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("회원을 삭제합니다. 회원의 고유번호를 입력해주세요");
		while (true) {
			String seq = Casino_Scan.inputSeq();
			Casino_Scan.isEnd("회원삭제", seq);
			try {
				dao.delete(Integer.parseInt(seq));
				System.out.println("삭제에 성공했습니다.");
				break;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("잘못된 값입니다 다시 입력해 주세요");
			} 
		}
	}

}
