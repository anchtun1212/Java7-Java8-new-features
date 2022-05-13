package com.anchtun.java8.interfaces.defaultmethod;

public interface Vehicle {

	int getSpeed();

	void applyBrake();

	// for example after long time we need this feature, so all classes that implements this interface
	// must implement this new method, so that way we add default method
	// you can keep the default implementation or override it in the classes that extends this interface
	default void autoPilot() {// by default will be: public default void autoPilot()
		System.out.println("Will help in drive without manual support");
	}
}
