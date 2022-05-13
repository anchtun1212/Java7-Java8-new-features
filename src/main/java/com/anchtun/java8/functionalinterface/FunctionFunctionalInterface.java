package com.anchtun.java8.functionalinterface;

import java.util.function.Function;

/**
 * Function is similar to Predicate except with a change that instead of return boolean can return any datatype as outcome
 */
public interface FunctionFunctionalInterface {

	public static void main(String[] args) {

		String str = "Anchtun";
		int a = 5;
		int b = 30;
		int by2 = 2;
		int by3 = 3;

		// create a Function
		// <String, String> means: input = String and also output = String
		Function<String, String> toUpperFunction = input -> input.toUpperCase();

		// call the toUpperFunction function
		System.out.println(str + " toUpperCase will be: " + toUpperFunction.apply(str));

		// use static method sameValue
		Function<String, String> sameValue = Function.identity();
		System.out.println("Same value of '" + str + "' will be: " + sameValue.apply(str));

		// create Multiplication function
		Function<Integer, Integer> multiplicationFunc = input -> {
			System.out.println("Multiplication * 2");
			return input * by2;
		};

		// chaining the multiplication with andThen
		multiplicationFunc = multiplicationFunc.andThen(input -> {
			System.out.println("Multiplication * 3");
			return input * by3;
		});
		System.out.println("Multiplication result: " + multiplicationFunc.apply(a));
		
		// create Division function
		Function<Integer, Integer> divisionFunc = input -> {
			System.out.println("Division / 2");
			return input / by2;
		};
		// chaining the Division with compose
		// in compose the last operation added will be execute first unlike andThen
		divisionFunc = divisionFunc.compose(input -> {
			System.out.println("Division / 3");
			return input / by3;
		});// will be executed first
		System.out.println("Division result: " + divisionFunc.apply(b));
	}
}
