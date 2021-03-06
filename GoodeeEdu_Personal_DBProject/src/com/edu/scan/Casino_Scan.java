package com.edu.scan;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.edu.Default_Page.admin.Casino_Admin_Factory;
import com.edu.Default_Page.user.Casino_User_Factory;
import com.edu.casino_Fac.Casino_Page_Factory;

public class Casino_Scan implements LoginState  {

	public static String inputName() {
		String name = null;
		Scanner scan = new Scanner(System.in);
		CorrectChecker check = (str) ->{
			/*이름의 유효성을 검사한다.*/
			boolean isc = false;
			String regex = "^[가-힣]{2,4}|[a-zA-Z]{2,10}\\s[a-zA-Z]{2,10}$";
			if(str.matches(regex)|| str.equalsIgnoreCase("exit")) {
				System.out.println("...Correct Name");
			}else {
				isc = true;
				try {
					Thread.sleep(200);
					System.err.println("...inCorrect Name");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return isc;
		};
		do {
			System.out.print("【  Name 】:  ");
			String str = scan.nextLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			name = st.nextToken();


		}while(check.isCorrect(name)	);
		return name;
	}
	
	@SuppressWarnings("resource")
	public static String inputID(){
		CorrectChecker checker = (str) -> {
			boolean isc = false;
			//아이디 유효성 검사
			String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
			if(str.matches(regex) || str.equalsIgnoreCase("exit")) {
				System.out.println("...Correct ID");
			}else {
				isc = true;
				try {
					Thread.sleep(200);
					System.err.println("...inCorrect ID");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return isc;
		};
		String iD = null;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("【   I  D 】:  ");
			iD = scan.next();
			
		} while (checker.isCorrect(iD));
		return iD;
	}
	@SuppressWarnings("resource")
	public static String inputPW() {

		String pW = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("【  P W 】:  ");
		pW = scan.next();

		return pW;
	}
		@SuppressWarnings("resource")
	public static String inputEmail() {
		CorrectChecker checker = (str) -> {
			boolean isc = false;
			//아이디 유효성 검사
			String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
			if(str.matches(regex)|| str.equalsIgnoreCase("exit")) {
				System.out.println("...Correct eMail");
			}else {
				isc = true;
				try {
					Thread.sleep(200);
					System.err.println("...inCorrect eMail");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return isc;
		};
		String eMail = null;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("【 email 】:  ");
			eMail = scan.next();
			if(Checker.checkString(eMail) ) {
				break;
			}
		} while (checker.isCorrect(eMail));
		return eMail;
	}
	@SuppressWarnings("resource")
	public static String inputPhone() {
		CorrectChecker checker = (str) -> {
			boolean isc = false;
			//아이디 유효성 검사
			String regex = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
			if(str.matches(regex)|| str.equalsIgnoreCase("exit")) {
				System.out.println("...Correct PhoneNumber");
			}else {
				isc = true;
				try {
					Thread.sleep(200);
					System.err.println("...inCorrect PhoneNumber");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return isc;
		};
		String phone = null;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("【phone】:  ");
			phone = scan.next();
		} while (checker.isCorrect(phone));
		return phone;
	}
	
	@SuppressWarnings("resource")
	public static boolean yesorno() {
		boolean isc = false;
		Scanner scan = new Scanner(System.in);
		String check = scan.next();
		
		return (check.equalsIgnoreCase("y") || check.equalsIgnoreCase("yes")  )? true : false ;
	}
	


	@SuppressWarnings("resource")
	public static int doController() {
		int doControl = DO_LOGIN ;
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.printf("1. LOGIN\t\t2. SIGN_IN\t3. FIND_ID\t4.FIND_PW\t5.CHANGE_PW\n");
			String str = scan.nextLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String next = st.nextToken();
			switch(next) {
			case "1": doControl = DO_LOGIN;			break;
			case "2":	doControl =DO_SIGNUP; 		break;
			case "3":	doControl =DO_FIND_ID ;		break;
			case "4":	doControl =DO_FIND_PW ;		break;
			default :	doControl =DO_LOGIN; 		break;
			}

			return doControl;
		}
	}
	@SuppressWarnings("resource")
	public static String FristPageController() {
		Scanner scan = new Scanner(System.in);
		System.out.println("하시고 싶은 작업을 선택하세요. \n종료를 원하시면 언제라도 exit를 눌러주세요!");
		
		System.out.println("1. 로그인\t2.회원가입\t3.아이디 찾기\t4.비밀번호 찾기");
		String result = scan.next();
		Casino_Scan.isExit("로그인시스템", result);
		return result;
	}
	
	@SuppressWarnings("resource")
	public static String userPageController() {
		Scanner scan = new Scanner(System.in);
		System.out.println("하시고 싶은 작업을 선택하세요. \n종료를 원하시면 언제라도 exit를 눌러주세요!");
		
		System.out.println("1. 내정보보기\t2. 비밀번호 변경\t 3.이메일 변경\t 4. 핸드폰 번호 변경\t ");
		String result = scan.next();
		Casino_Scan.isEnd("유저 페이지", result);
		return result;
	}
	@SuppressWarnings("resource")
	public static String adminPageController() {
		Scanner scan = new Scanner(System.in);
		System.out.println("하시고 싶은 작업을 선택하세요. \n종료를 원하시면 언제라도 exit를 눌러주세요!");
		System.out.println("1. 회원검색\t 2. 모든 회원 검색\t 3. 회원 삭제\t 4.친구보기");

		String result = scan.next();
		Casino_Scan.isEnd("어드민 페이지", result);
		return result;
	}
	
	@SuppressWarnings("resource")
	public static String inputSeq() {
		Scanner scan = new Scanner(System.in);
		String result = scan.next();
		
		return result;
	}
	public static void isExit(String state, String str) {
		if(str.equalsIgnoreCase("exit")|| str.equalsIgnoreCase("quit")){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println(state+"을(를) 종료합니다.");
			System.exit(0);
		}
	}
	/**
	 * @return exit 입력시 true
	 * */
	public static void isEnd(String state, String str){
		if(str.equalsIgnoreCase("exit")|| str.equalsIgnoreCase("quit")){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println(state+"을(를) 종료합니다.");
			Casino_Page_Factory.getInstance().factroy();
		}
	}
	public static void isEndAdmin(String state, String str){
		if(str.equalsIgnoreCase("exit")|| str.equalsIgnoreCase("quit")){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println(state+"을(를) 종료합니다.");
			Casino_Admin_Factory.getInstance().factory();
		}
	}
	public static void isEndUser(String state, String str){
		if(str.equalsIgnoreCase("exit")|| str.equalsIgnoreCase("quit")){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println(state+"을(를) 종료합니다.");
			Casino_User_Factory.getInstance().factory();
		}
	}
}
