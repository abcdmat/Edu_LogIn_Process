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
//							System.err.println("�̹� ���Ե� ���̵� �Դϴ�.\n �ٽ� �Է����ּ���");
//						}
//					} while (!dao.checkID(dto));
//					pW = Casino_Scan.inputPW();
//					dto = dao.login(new Casino_Dto(Casino_Scan.inputID(), Casino_Scan.inputPW()));
//					if (dto == null) {
//						System.err.println("...�߸��� ��й�ȣ�Դϴ�.");
//						Thread.sleep(300);
//						System.out.println("���̵� ã���ðڽ��ϱ�?");
//						// TODO 1. �̰��� ���̵� ã�°ŷ� ����Ǵ� �������� ���� ( ControllIndex���� �����ϸ� ��
//						controllIndex = DO_FIND_ID;
//					} else { // �α��� ������ Player���
//						if (dto.getJOB().equals("P")) {
//							System.out.println("����������.........");
//							Thread.sleep(300);
//							System.out.println("���������� .......");
//							Thread.sleep(300);
//							System.out.println("����������  .....");
//							Thread.sleep(300);
//							System.out.println("����������   ...");
//							Thread.sleep(300);
//							System.out.println("����������    .");
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
//				 * ȸ�����Խ� ���� ���� JOB FLAG�� ����Ʈ ������ �Էµǵ��� �����ؾ��Ѵ�. ����Ʈ ���� 'P'�� �÷��̾ ��Ÿ����. ģ�� ID �Է½�
//				 * ģ������ 500�� �Ӵ� ����( ģ�����̵� ������ ���ٰ� ������ �϶�) ȸ�������Ҷ� ID ,PW, NAME, PHONE, EMAIL +
//				 * ģ�����̵� �����Է� ID�� �Է������� �ߺ�ó�� �����ϰ�
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
//						// Ʈ��ϱ� ������ ���̵� ����
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
//						// �ȳ���
//						dto.setFRIEND_ID("null");
//					}
//				} while (dao.signIn(dto)); // ������ insert ���нÿ� true ��ȯ�ϰ� ����. �׷��� ���� ���н� �ٽ� �����ϵ���
//				break;
//			case DO_FIND_ID:
//				do {
//					// �̸��ϰ� �̸����� ���̵� ã�´�.
//					System.out.println("�̸��� E-Mail�� ���̵� ã���ϴ�");
//					dto = new Casino_Dto(Casino_Scan.inputName(), Casino_Scan.inputEmail());
//					dto = dao.findID(dto);
//					if (dto == null) {
//
//					} else {
//						System.out.println("����� ���̵�� : " + dto.getID() + " �Դϴ�.");
//						break;
//					} 
//				} while (true);
//				break;
//			case DO_FIND_PW:
//				do {
//					// ���̵�� �̸��Ϸ� ��й�ȣã�´�.
//					System.out.println("ID�� E-Mail�� ��й�ȣ�� ã���ϴ�");
//					dto = new Casino_Dto(Casino_Scan.inputID(), Casino_Scan.inputEmail());
//					dto = dao.findPW(dto);
//					if (dto == null) {
//
//					} else {
//						System.out.println("����� ��й�ȣ�� : " + dto.getPW() + " �Դϴ�.");
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
