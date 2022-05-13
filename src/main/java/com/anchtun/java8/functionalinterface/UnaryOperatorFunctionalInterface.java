package com.anchtun.java8.functionalinterface;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * If we have a scenario where both the input and output parameters data type are same, then instead of use
 * Function<T,R> we can use UnaryOperator<T> 
 */
public interface UnaryOperatorFunctionalInterface {

	public static void main(String[] args) {

		String str = "Anchtun";
		int a = 5;
		int by2 = 2;
		int by3 = 3;

		// create a Function
		UnaryOperator<String> toUpperFunction = input -> input.toUpperCase();

		// call the toUpperFunction function
		System.out.println(str + " toUpperCase will be: " + toUpperFunction.apply(str));

		// use static method sameValue
		UnaryOperator<String> sameValue = UnaryOperator.identity();
		System.out.println("Same value of '" + str + "' will be: " + sameValue.apply(str));

		// create Multiplication function * 2
		Function<Integer, Integer> multiplicationFuncBy2 = input -> {
			System.out.println("Multiplication * 2");
			return input * by2;
		};

		// create Multiplication function * 3
		UnaryOperator<Integer> multiplicationFuncBy3 = input -> {
			System.out.println("Multiplication * 3");
			return input * by3;
		};
		
		// chaining the multiplication with andThen
		multiplicationFuncBy2 = multiplicationFuncBy2.andThen(multiplicationFuncBy3);
		System.out.println("Multiplication with 'andThen' result: " + multiplicationFuncBy2.apply(a));
		
		// chaining the multiplication with compose
		multiplicationFuncBy2 = multiplicationFuncBy2.compose(multiplicationFuncBy3);
		System.out.println("Multiplication with 'compose' result: " + multiplicationFuncBy2.apply(a));
	}
}
