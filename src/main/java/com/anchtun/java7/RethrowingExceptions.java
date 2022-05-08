package com.anchtun.java7;

/**
 * Rethrowing exceptions with more inclusive type checking
 */
public class RethrowingExceptions {

	private final static String NAME = "Anchtun";

	public static void main(String[] args) throws Exception {
		// beforeJava7
		System.out.println("Before Java 7");
		// beforeJava7(NAME);
		// withJava7
		System.out.println("With Java 7");
		withJava7(NAME);
	}

	// the method throws only the exceptions presents in catch block
	private static void beforeJava7(String name) throws Exception {
		try {
			if (name.equals("Anchtun")) {
				throw new FirstTypeException();
			} else {
				throw new SecondTypeException();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// the methods can throws any exception
	private static void withJava7(String name) throws FirstTypeException, SecondTypeException {
		try {
			if (name.equals("Anc")) {
				throw new FirstTypeException();
			} else {
				throw new SecondTypeException();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	static class FirstTypeException extends Exception {
	}

	static class SecondTypeException extends Exception {
	}

	static class ThirdTypeException extends Exception {
	}
}
