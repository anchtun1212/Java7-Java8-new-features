package com.anchtun.java7;

/**
 * Before Java 7, switch statement allow only Enum and int types
 */
public class SwitchWithString {

	public static void main(String[] args) {
		// String msg = "anchtun";
		String msg = "mohamed";
		// String msg = "aymen";
		// String msg = "other";
		switch (msg) {
		// multi case that have the same business logic in the same line
		case "anchtun": case "aymen": case "mohamed":
			System.out.println("Hello Admin!!");
			break;
		default:
			System.out.println("Hello user");
			break;
		}
	}
}
