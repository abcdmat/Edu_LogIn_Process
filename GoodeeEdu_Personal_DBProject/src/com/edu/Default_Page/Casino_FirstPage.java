package com.edu.Default_Page;
//package com.edu.Page;
//
//import com.edu.dao.Casino_Dao;
//import com.edu.dto.Casino_Dto;
//import com.edu.scan.Casino_Scan;
//import com.edu.scan.Checker;
//import com.edu.scan.LoginState;
//
//public class Casino_FirstPage extends Casino_Page_Impl implements LoginState {
//
//	public void FirstPage() throws InterruptedException {
//		Casino_Dao dao = new Casino_Dao();
//		Casino_Dto dto = null;
//		boolean state = false;
//		int controllIndex = 0;
//		do {
//			if(controllIndex ==0) {
//				controllIndex = Casino_Scan.doController();
//			}
//			switch (controllIndex) {
//			case DO_LOGIN:
//				dto= null;
//				String iD;
//				String pW;
//				do {
//					iD = "";
//					do {
//						iD = Casino_Scan.inputID();
//						dto = new Casino_Dto(iD);
//						if (!Checker.checkString(iD)) {
//							break;
//						}
//						if(!dao.checkID(dto)) {
//							System.err.println("이미 가입된 아이디 입니다.\n 다시 입력해주세요");
//						}
//					} while (!dao.checkID(dto));
//					pW = Casino_Scan.inputPW();
//					dto = dao.login(new Casino_Dto(Casino_Scan.inputID(), Casino_Scan.inputPW()));
//					if (dto == null) {
//						System.err.println("...잘못된 비밀번호입니다.");
//						Thread.sleep(300);
//						System.out.println("아이디를 찾으시겠습니까?");
//						// TODO 1. 이곳에 아이디를 찾는거로 연결되는 로직으로 ㄱㄱ ( ControllIndex값을 변경하면 됨
//						controllIndex = DO_FIND_ID;
//					} else { // 로그인 성공시 Player라면
//						if (dto.getJOB().equals("P")) {
//							System.out.println("　　　　　.........");
//							Thread.sleep(300);
//							System.out.println("　　　　　 .......");
//							Thread.sleep(300);
//							System.out.println("　　　　　  .....");
//							Thread.sleep(300);
//							System.out.println("　　　　　   ...");
//							Thread.sleep(300);
//							System.out.println("　　　　　    .");
//							System.out.println("GameStart");
//						} else if (dto.getJOB().equals("A")) {
//							System.out.println("member management system");
//						}
//						state = STATE_LOGIN;
//						break;
//					}
//					break;
//				} while (true);
//			case DO_SIGNUP:
//				/*
//				 * 회원가입시 가장 뒤의 JOB FLAG를 디폴트 값으로 입력되도록 생성해야한다. 디폴트 값은 'P'로 플레이어를 나타낸다. 친구 ID 입력시
//				 * 친구에게 500의 머니 증정( 친구아이디가 없으면 없다고 나오게 하라) 회원가입할때 ID ,PW, NAME, PHONE, EMAIL +
//				 * 친구아이디 선택입력 ID만 입력했을때 중복처리 가능하게
//				 */
//				dto = new Casino_Dto();
//				dto.setJOB("P");
//				do {
//					iD = "";
//					do {
//						iD = Casino_Scan.inputID();
//						dto.setID(iD);
//					} while (dao.checkID(dto));
//					if (!Checker.checkString(iD)) {
//						break;
//					}
//					pW = Casino_Scan.inputPW();
//					dto.setPW(pW);
//					if (!Checker.checkString(pW)) {
//						break;
//					}
//					String name = Casino_Scan.inputName();
//					dto.setNAME(name);
//					if (!Checker.checkString(name)) {
//						break;
//					}
//					do {
//						String eMail = Casino_Scan.inputEmail();
//						dto.setEMAIL(eMail);
//						if (!Checker.checkString(eMail)) {
//							break;
//						}
//					} while (dao.checkEmail(dto));
//					if (!Checker.checkString(dto.getEMAIL())) {
//						break;
//					}
//					do {
//						String phone = Casino_Scan.inputPhone();
//						dto.setPHONE(phone);
//						if (!Checker.checkString(phone)) {
//							break;
//						}
//					} while (dao.checkPhone(dto));
//					if (!Checker.checkString(dto.getPHONE())) {
//						break;
//					}
//					System.out.println("INSERT FRIEND?");
//					if (Casino_Scan.yesorno()) {
//						// 트루니까 프랜드 아이디 넣음
//						do {
//							System.out.println("Frined ID Input");
//							String fiD = Casino_Scan.inputID();
//							dto.setFRIEND_ID(fiD);
//							if (!Checker.checkString(fiD)) {
//								break;
//							}
//						} while (dao.checkFID(dto));
//						if (!Checker.checkString(dto.getFRIEND_ID())) {
//							break;
//						}
//					} else {
//						// 안넣음
//						dto.setFRIEND_ID("null");
//					}
//				} while (dao.signIn(dto)); // 조건은 insert 실패시에 true 반환하게 하자. 그래서 생성 실패시 다시 실행하도록
//				break;
//			case DO_FIND_ID:
//				do {
//					// 이메일과 이름으로 아이디를 찾는다.
//					System.out.println("이름과 E-Mail로 아이디를 찾습니다");
//					dto = new Casino_Dto(Casino_Scan.inputName(), Casino_Scan.inputEmail());
//					dto = dao.findID(dto);
//					if (dto == null) {
//
//					} else {
//						System.out.println("당신의 아이디는 : " + dto.getID() + " 입니다.");
//						break;
//					} 
//				} while (true);
//				break;
//			case DO_FIND_PW:
//				do {
//					// 아이디와 이메일로 비밀번호찾는다.
//					System.out.println("ID와 E-Mail로 비밀번호를 찾습니다");
//					dto = new Casino_Dto(Casino_Scan.inputID(), Casino_Scan.inputEmail());
//					dto = dao.findPW(dto);
//					if (dto == null) {
//
//					} else {
//						System.out.println("당신의 비밀번호는 : " + dto.getPW() + " 입니다.");
//						break;
//					} 
//				} while (true);
//				break;
//
//			}
//
//		} while (state == STATE_DEFAULT);
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
//}
