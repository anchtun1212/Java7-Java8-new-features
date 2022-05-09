package com.anchtun.java7;

/**
 * We just need to add prefix of either 0b/OB in front of integral types(byte/short/int/long),
 * then Java will take care of converting it into a decimal representation value of it
 */
public class BinaryLiterals {

	public static void main(String[] args) {
		byte byteBinary = 0b0111;
		short shortBinary = 0B00111101;
		int intBinary = 0B1011110111100011;
		long longBinary = 0b10111101111000111011110111100011;
		System.out.println("byteBinary= " + byteBinary);
		System.out.println("shortBinary= " + shortBinary);
		System.out.println("intBinary= " + intBinary);
		System.out.println("longBinary= " + longBinary);
	}
}
