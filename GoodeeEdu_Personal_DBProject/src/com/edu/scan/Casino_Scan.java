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
			/*ÀÌ¸§ÀÇ À¯È¿¼ºÀ» °Ë»çÇÑ´Ù.*/
			boolean isc = false;
			String regex = "^[°¡-ÆR]{2,4}|[a-zA-Z]{2,10}\\s[a-zA-Z]{2,10}$";
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
			System.out.print("¡¼  Name ¡½:  ");
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
			//¾ÆÀÌµð À¯È¿¼º °Ë»ç
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
			System.out.print("¡¼   I  D ¡½:  ");
			iD = scan.next();
			
		} while (checker.isCorrect(iD));
		return iD;
	}
	@SuppressWarnings("resource")
	public static String inputPW() {

		String pW = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("¡¼  P W ¡½:  ");
		pW = scan.next();

		return pW;
	}
		@SuppressWarnings("resource")
	public static String inputEmail() {
		CorrectChecker checker = (str) -> {
			boolean isc = false;
			//¾ÆÀÌµð À¯È¿¼º °Ë»ç
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
			System.out.print("¡¼ email ¡½:  ");
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
			//¾ÆÀÌµð À¯È¿¼º °Ë»ç
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
			System.out.print("¡¼phone¡½:  ");
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
		System.out.println("ÇÏ½Ã°í ½ÍÀº ÀÛ¾÷À» ¼±ÅÃÇÏ¼¼¿ä. \nÁ¾·á¸¦ ¿øÇÏ½Ã¸é ¾ðÁ¦¶óµµ exit¸¦ ´­·¯ÁÖ¼¼¿ä!");
		
		System.out.println("1. ·Î±×ÀÎ\t2.È¸¿ø°¡ÀÔ\t3.¾ÆÀÌµð Ã£±â\t4.ºñ¹Ð¹øÈ£ Ã£±â");
		String result = scan.next();
		Casino_Scan.isExit("·Î±×ÀÎ½Ã½ºÅÛ", result);
		return result;
	}
	
	@SuppressWarnings("resource")
	public static String userPageController() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ÇÏ½Ã°í ½ÍÀº ÀÛ¾÷À» ¼±ÅÃÇÏ¼¼¿ä. \nÁ¾·á¸¦ ¿øÇÏ½Ã¸é ¾ðÁ¦¶óµµ exit¸¦ ´­·¯ÁÖ¼¼¿ä!");
		
		System.out.println("1. ³»Á¤º¸º¸±â\t2. ºñ¹Ð¹øÈ£ º¯°æ\t 3.ÀÌ¸ÞÀÏ º¯°æ\t 4. ÇÚµåÆù ¹øÈ£ º¯°æ\t ");
		String result = scan.next();
		Casino_Scan.isEnd("À¯Àú ÆäÀÌÁö", result);
		return result;
	}
	@SuppressWarnings("resource")
	public static String adminPageController() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ÇÏ½Ã°í ½ÍÀº ÀÛ¾÷À» ¼±ÅÃÇÏ¼¼¿ä. \nÁ¾·á¸¦ ¿øÇÏ½Ã¸é ¾ðÁ¦¶óµµ exit¸¦ ´­·¯ÁÖ¼¼¿ä!");
		System.out.println("1. È¸¿ø°Ë»ö\t 2. ¸ðµç È¸¿ø °Ë»ö\t 3. È¸¿ø »èÁ¦\t 4.Ä£±¸º¸±â");

		String result = scan.next();
		Casino_Scan.isEnd("¾îµå¹Î ÆäÀÌÁö", result);
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
			System.err.println(state+"À»(¸¦) Á¾·áÇÕ´Ï´Ù.");
			System.exit(0);
		}
	}
	/**
	 * @return exit ÀÔ·Â½Ã true
	 * */
	public static void isEnd(String state, String str){
		if(str.equalsIgnoreCase("exit")|| str.equalsIgnoreCase("quit")){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println(state+"À»(¸¦) Á¾·áÇÕ´Ï´Ù.");
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
			System.err.println(state+"À»(¸¦) Á¾·áÇÕ´Ï´Ù.");
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
			System.err.println(state+"À»(¸¦) Á¾·áÇÕ´Ï´Ù.");
			Casino_User_Factory.getInstance().factory();
		}
	}
}
