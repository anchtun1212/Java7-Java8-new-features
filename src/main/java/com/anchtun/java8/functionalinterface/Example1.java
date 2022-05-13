package com.anchtun.java8.functionalinterface;

//this annotation is optional; just to help you to know that this interface is a Functional Interface
//but when we add it the compiler avoid you to add two abstract methods
//functional interface MUST have a Single Abstract Method (SAM)
//functional interface can have many default methods
//functional interface can have many static methods
//functional interface can have many private methods
@FunctionalInterface
public interface Example1 {

	// only 1 Abstract Method (SAM)
	public void saySalam(String person);

	// try to add other Abstract method: compiler error: because @FunctionalInterface avoid that
	//public void saySalam(String person);// compiler error: because @FunctionalInterface avoid that

	// default method
	public default void sayShahadatayn() {
		System.out.println("Ashhad an la illah illa Allah, wa ashhad anna Mohammed rassul Allah");
	}

	// 2 static methods
	public static void printAddition(int a, int b) {
		System.out.println(a + "+" + b + " = " + (a + b));
	}

	public static void printMultiplication(int a, int b) {
		System.out.println(a + "*" + b + " = " + (a * b));
	}

	// private method
	private float sizeInMeter(int sizeInCentemeter) {
		return (float) (sizeInCentemeter * 0.01);
	}

	public static void main(String[] args) {
		Example1 example = person -> System.out.println("Assalam Ayakom " + person);
		// call SAM
		example.saySalam("Anchtun");

		// call default method
		example.sayShahadatayn();

		int a = 5;
		int b = 22;
		// call static methods
		printAddition(a, b);
		printMultiplication(a, b);

		// call private method
		System.out.println("Size in meter: " + example.sizeInMeter(175));

	}
}
