package com.edu.Default_Page.admin;

import java.util.ArrayList;

import com.edu.dto.Casino_Dto;

public class Casino_Admin_SelectAll extends Casino_AdminPage_Impl {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//��� ȸ�� ������ ����Ѵ�.
		ArrayList<Casino_Dto> dto = new ArrayList<Casino_Dto>();
		dto = dao.selectAll();
		for(Casino_Dto d : dto) {
			System.out.println(d);
			
		}
		
	}

}
