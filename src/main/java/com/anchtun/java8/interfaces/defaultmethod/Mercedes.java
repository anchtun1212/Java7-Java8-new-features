package com.anchtun.java8.interfaces.defaultmethod;

public class Mercedes implements Vehicle {

	@Override
	public int getSpeed() {
		return 80;
	}

	@Override
	public void applyBrake() {
		System.out.println("Brakes applyed");
	}

	public static void main(String[] args) {
		Mercedes mercedes = new Mercedes();
		System.out.println("The speed is= " + mercedes.getSpeed());
		mercedes.applyBrake();
		// call the default method WITHOUT override it
		mercedes.autoPilot();
	}
}
