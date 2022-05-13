package com.anchtun.java8.functionalinterface;

import java.util.function.Consumer;

/**
 * Will always consumes/accept the given input for processing but not return anything to the invocation method
 */
public interface ConsumerFunctionalInterface {

	public static void main(String[] args) {

		String str = "Anchtun";

		// create a Consumer
		Consumer<String> consumer = input -> System.out.println(input + " toUpperCase = " + input.toUpperCase());
		consumer.accept(str);

		// create another Consumer
		Consumer<String> consumerAppend = input -> System.out.println("Hello " + input.toUpperCase() + "!!!");
		consumer.andThen(consumerAppend).accept(str);
	}
}
