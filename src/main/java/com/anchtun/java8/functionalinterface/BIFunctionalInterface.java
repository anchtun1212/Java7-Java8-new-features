package com.anchtun.java8.functionalinterface;

import java.util.function.BinaryOperator;

/**
 * BiPredicate<T,U> similar to Predicate but accept two input parameters and return boolean value
 * BiFunction<T,U,R> similar to Function but it can accept two input parameters and return an output as per the data type mentioned
 * BiConsumer<T,U> similar to Consumer but accept two input parameters and return same type as Consumer
 * THERE IS NO BiSupplier
 * BinaryOperator<T> is a child of BiFunction<T,U,R>: We will use this in the scenario 
 * where the 2 input parameters and 1 return parameter data types are the same
 */
public interface BIFunctionalInterface {

	public static void main(String[] args) {

		String firstName = "Mohamed Aymen";
		String familyName = "Charrada";
		int a = 30;
		int b = 5;

		// create BinaryOperator
		BinaryOperator<String> appendAndConvertUpper = (str1, str2) -> (str1 + " " + str2).toUpperCase();
		String fullName = appendAndConvertUpper.apply(firstName, familyName);
		System.out.println("The full name is: " + fullName);

		// use static methods minBy and maxBy: use logic of Compare (Comparator)
		BinaryOperator<Integer> max = BinaryOperator.maxBy((x, y) -> (x > y) ? 1 : (x == y) ? 0 : -1);
		BinaryOperator<Integer> min = BinaryOperator.minBy((x, y) -> (x > y) ? 1 : (x == y) ? 0 : -1);
		System.out.println("max: " + max.apply(a, b));
		System.out.println("min: " + min.apply(a, b));
	}
}
