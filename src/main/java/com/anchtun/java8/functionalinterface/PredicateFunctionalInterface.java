package com.anchtun.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate functional interface handles the scenarios where we accept an input parameter
 * and return a boolean after processing the input
 */
public interface PredicateFunctionalInterface {

	public static void main(String[] args) {

		int a = 5;
		int b = 22;
		int c = 4;
		String str1 = "Anchtun";
		String str2 = "Aymen";

		// create a Predicate to check if the input number is even
		Predicate<Integer> isEven = input -> input % 2 == 0;

		// call the predicate
		System.out.println("Is " + a + " even? " + isEven.test(a));
		System.out.println("Is " + b + " even? " + isEven.test(b));

		// create a Predicate to check if the input number > 20
		Predicate<Integer> isGreaterThan20 = input -> input > 20;

		// predicate AND chaining
		System.out.println("Is " + a + " even AND > 20? " + isEven.and(isGreaterThan20).test(a));
		System.out.println("Is " + b + " even AND > 20? " + isEven.and(isGreaterThan20).test(b));

		// predicate OR chaining
		System.out.println("Is " + c + " either even OR > 20? " + isEven.or(isGreaterThan20).test(c));

		// predicate negate chaining (like NOT)
		System.out.println("Is " + a + " odd? " + isEven.negate().test(a));
		System.out.println("Is " + a + " < 20? " + isGreaterThan20.negate().test(a));

		// Usage of predicate inside Collections & Streams
		List<Integer> intList = Arrays.asList(1, 5, 8, 12, 13, 22, 30, 84);
		List<Integer> evenList = intList.stream().filter(isEven).collect(Collectors.toList());
		List<Integer> oddList = intList.stream().filter(isEven.negate()).collect(Collectors.toList());

		System.out.println("Even numbers in the list are: " + evenList);
		System.out.println("Odd numbers in the list are: " + oddList);

		// use static isEqual method
		Predicate<String> isEqual = Predicate.isEqual("Anchtun");
		System.out.println(str1 + " isEqual to Anchtun? " + isEqual.test(str1));
		System.out.println(str2 + " isEqual to Anchtun? " + isEqual.test(str2));
	}
}
