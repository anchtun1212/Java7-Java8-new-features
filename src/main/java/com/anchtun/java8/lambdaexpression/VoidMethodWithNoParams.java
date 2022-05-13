package com.anchtun.java8.lambdaexpression;

// @FunctionalInterface used for an interface that have only one abstract method
// but this interface can have default methods or static methods

@FunctionalInterface
public interface VoidMethodWithNoParams {

	public void sayAlShahadatan();

	default void sayHello() {
		System.out.println("Hello");
	}

	static void sayBye() {
		System.out.println("Bye");
	}

}
