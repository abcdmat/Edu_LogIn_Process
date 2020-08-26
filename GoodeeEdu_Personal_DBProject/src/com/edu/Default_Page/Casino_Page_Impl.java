package com.edu.Default_Page;

import com.edu.dao.Casino_Dao;
import com.edu.dto.Casino_Dto;

public abstract class Casino_Page_Impl implements ICasino_Interface{
	protected Casino_Dto dto;
	protected Casino_Dao dao;
	public Casino_Page_Impl() {
		// TODO Auto-generated constructor stub
		dao = new Casino_Dao();
	}
	public Casino_Page_Impl(Casino_Dto dto ) {
		this.dto = dto;
	}
	
	@Override
	public abstract void run() ;
	
	public Casino_Dto getDto() {
		return dto;
	}

}
