package com.contactslist.api.tests;

public class Temp {
	
	
	public static void verify(String... values) {
		if(values[0].isEmpty()) {
			System.out.println(true);
			//System.out.println(values[0]);
		} else {
			System.out.println(values[0]);
		}
	}
	
	
	public static void main(String[] args) {
		String token = "";
		verify(token);
	}

}
