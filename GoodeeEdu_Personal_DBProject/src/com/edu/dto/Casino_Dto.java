package com.edu.dto;import java.sql.Date;

public class Casino_Dto {
	private int SEQ;
	private String ID;
	private String PW;
	private String NAME;
	private String PHONE;
	private String EMAIL;
	private String REGISTER_DATE;
	private String FRIEND_ID;
	private String JOB;
	
	public void reset() {
		
	}
	public Casino_Dto() {
		// TODO Auto-generated constructor stub
		this(9999, "Test","test","Test001","00000000000","0000@000.00.00", "0000-00-00", "0000", "A");
	}

	public Casino_Dto(String iD, String pW) {
		super();
		ID = iD;
		PW = pW;
	}

	public Casino_Dto(String iD) {
		super();
		ID = iD;
	}

	
	
	public Casino_Dto(String iD, String pW, String nAME, String pHONE, String eMAIL, String fRIEND_ID) {
		super();
		ID = iD;
		PW = pW;
		NAME = nAME;
		PHONE = pHONE;
		EMAIL = eMAIL;
		FRIEND_ID = fRIEND_ID;
	}
	public Casino_Dto(int sEQ, String iD, String pW, String nAME, String pHONE, String eMAIL, String rEGISTER_DATE,
			String fRIEND_ID, String jOB) {
		super();
		SEQ = sEQ;
		ID = iD;
		PW = pW;
		NAME = nAME;
		PHONE = pHONE;
		EMAIL = eMAIL;
		REGISTER_DATE = rEGISTER_DATE;
		FRIEND_ID = fRIEND_ID;
		JOB = jOB;
	}
	@Override
	public String toString() {
		String job = JOB;
		if(JOB.equals("P")) {
			job = "사용자";
		}else {
			job = "관리자";
		}
		
		return "회원 정보  [회원번호 : " + SEQ + "] [아이디 : " + ID + "] [비밀번호 : " + PW + "]\n [이름 : " + NAME + "] [전화번호 : " + PHONE
				+ "] [이메일 : " + EMAIL + "]\n [가입 일자 : " + REGISTER_DATE + "] [추천인 : " + FRIEND_ID + "] [상태 : " + job
				+ "]";
	}
	public int getSEQ() {
		return SEQ;
	}
	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getREGISTER_DATE() {
		return REGISTER_DATE;
	}
	public void setREGISTER_DATE(String rEGISTER_DATE) {
		REGISTER_DATE = rEGISTER_DATE;
	}
	public String getFRIEND_ID() {
		return FRIEND_ID;
	}
	public void setFRIEND_ID(String fRIEND_ID) {
		FRIEND_ID = fRIEND_ID;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	
	
}
