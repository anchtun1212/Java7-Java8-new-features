package com.anchtun.java7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SuppressedExceptions {
	
	/**
	 * new two methods added in Java 7
	 * Throwable.getSuppressed()
	 * Throwable.addSuppressed(aThrowable)
	 */
	

	private static final Logger LOGGER = Logger.getLogger(SuppressedExceptions.class.getName());

	public static void main(String[] args) {
		// beforeJava7
		try {
			beforeJava7();
		} catch (Exception e) {
			// we loose the truck of the original exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		// withJava7
		// from Java7 when you log the exception, the original exception will be given to the user
		// all the subsequent exceptions will be present in getSuppressed
		try {
			withJava7();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			final Throwable[] suppressedExceptions = e.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				for (Throwable throwable : suppressedExceptions) {
					LOGGER.log(Level.SEVERE, throwable.getMessage());
				}
			}
		}
	}

	private static void beforeJava7() {
		CustomDirtyResource cr = null;
		try {
			cr = new CustomDirtyResource();
			cr.readFromResources();
		} finally {
			cr.close();
		}
	}

	private static void withJava7() {
		try (CustomDirtyResource cr = new CustomDirtyResource();) {
			cr.readFromResources();
		}
	}
}
