package com.edu.scan;

public class Checker {
	public static boolean checkString(String str){
		boolean isc = true;
		if(str.equalsIgnoreCase("Exit")|| str.equalsIgnoreCase("quit")){
			System.out.println("�ܰ踦 �����մϴ�.");
			isc = false;
		}
		return isc;
	}
}
