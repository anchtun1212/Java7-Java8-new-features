package com.anchtun.java8.interfaces.staticmethod;

public interface Vehicle {

	/**
	 * static methods cannot be overridden
	 */
	public static void autoPilot() {
		System.out.println("AutoPilot technology");
	}
}
