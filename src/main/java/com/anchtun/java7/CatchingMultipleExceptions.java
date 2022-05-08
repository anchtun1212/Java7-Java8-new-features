package com.anchtun.java7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchingMultipleExceptions {

	private static final Logger LOGGER = Logger.getLogger(SuppressedExceptions.class.getName());

	public static void main(String[] args) {
		// we need to implement each exception type in a separate catch block
		beforeJava7();
		// we can regroup many exceptions in the same catch block if they have the same business logic
		withJava7();
	}

	public static void beforeJava7() {
		int array[] = { 1, 2, 3, 4, 5 };
		//int array[] = null;
		try {
			for (int i = 0; i < array.length + 1; i++) {
				System.out.println(array[i]);
			}
		} catch (NullPointerException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
	}

	public static void withJava7() {
		int array[] = { 1, 2, 3, 4, 5 };
		//int array[] = null;
		try {
			for (int i = 0; i < array.length + 1; i++) {
				System.out.println(array[i]);
			}
		} catch (NullPointerException | ArrayIndexOutOfBoundsException | ClassCastException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
	}
}
