package com.anchtun.java8.interfaces.defaultmethod;

public class Bmw implements Vehicle {

	@Override
	public int getSpeed() {
		return 100;
	}

	@Override
	public void applyBrake() {
		System.out.println("Brakes applyed");
	}

	// override the default method
	@Override
	public void autoPilot() {
		System.out.println("AutoPilot system by BMW");
	}
	
	public static void main(String[] args) {
		Bmw mercedes = new Bmw();
		System.out.println("The speed is= " + mercedes.getSpeed());
		mercedes.applyBrake();
		mercedes.autoPilot();
	}
}
