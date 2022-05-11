package com.anchtun.java8.interfaces.staticmethod;

public class Mercedes implements Vehicle {

	private static void autoPilot() {
		System.out.println("AutoPilot technology, inside Mercedes");
	}

	public static void main(String[] args) {
		Mercedes.autoPilot();
		Vehicle.autoPilot();
	}
}
