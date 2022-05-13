package com.anchtun.java7;

/**
 * From Java 7 we can use the underscore (_) inside numeric values to improve readability of the code.
 * The compiler will remove them internally.
 * Not allowed at the beginning or at the end of a number.
 * Not allowed adjacent to the decimal point / L/F suffix that we use to indicate Long/float.
 *
 */
public class UnderscoreInsideNumeric {

	public static void main(String[] args) {
		int num1 = 1_000_000_000;
		// int num2 = _1000_000;// compile error
		// float num2 = 1000000_F;// // compile error
		long num3 = 1_000_000L;
		System.out.println("num1=" + num1);
		System.out.println("num3=" + num3);
	}
}
