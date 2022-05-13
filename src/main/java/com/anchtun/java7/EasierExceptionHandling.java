package com.anchtun.java7;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Easier exception handling for reflective methods
 *
 */
public class EasierExceptionHandling {

	private static final Logger LOGGER = Logger.getLogger(SuppressedExceptions.class.getName());

	public static void main(String[] args) {
		// beforeJava7
		beforeJava7();
		// withJava7
		withJava7();
	}

	public static void beforeJava7() {
		try {
			Class.forName("com.anchtun.java7.CatchingMultipleExceptions")
			.getMethod("beforeJava7")
			.invoke(null, new Object[] {});
		} catch (IllegalAccessException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		} catch (InvocationTargetException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		} catch (NoSuchMethodException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		} catch (ClassNotFoundException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
	}

	// new class: ReflectiveOperationException that regroup all expected exceptions
	public static void withJava7() {
		try {
			Class.forName("com.anchtun.java7.CatchingMultipleExceptions")
			.getMethod("beforeJava7")
			.invoke(null,new Object[] {});
		} catch (ReflectiveOperationException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
	}
}
