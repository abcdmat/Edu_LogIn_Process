package com.edu.scan;

public class Checker {
	public static boolean checkString(String str){
		boolean isc = true;
		if(str.equalsIgnoreCase("Exit")|| str.equalsIgnoreCase("quit")){
			System.out.println("단계를 종료합니다.");
			isc = false;
		}
		return isc;
	}
}
