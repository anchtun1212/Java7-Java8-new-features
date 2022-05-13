package com.anchtun.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) throws Exception {
		String file = System.getProperty("user.home") + "/file.txt";
		System.out.println("file path= " + file);
		beforeJava7(file);
		withJava7(file);
		withAutoCloseable(file);
	}

	private static void beforeJava7(String file) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			System.out.println("File content-beforeJava7:");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			br.close();
		}
	}

	/**
	 * with Java 7 we can add the resources inside try() and remove the finally block
	 */
	private static void withJava7(String file) throws IOException {
		// you can create any number of resources inside try bracket()
		// the resources inside the try bracket are final
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			String line;
			System.out.println("File content-withJava7:");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		// the br resource will be closed automatically
	}

	/**
	 * use the new interface in Java 7: AutoCloseable
	 */
	private static void withAutoCloseable(String file) throws Exception {
		try (CustomResource cr = new CustomResource();) {
			System.out.println("File content-withAutoCloseable:");
			cr.readFromResources(file);
		}
	}
}
