package com.anchtun.java8.methodconstructorref;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		staticMethodReference();
		instanceMethodObjReference();
		instanceMethodWithClassName();
	}

	private static void staticMethodReference() {
		ArithmeticOperation arithmeticOperation = (a, b) -> {
			int result = a + b;
			System.out.println("Addition from Lamda expression= " + result);
			return result;
		};
		arithmeticOperation.printResult(5, 12);
		// since the logic of the lambda expression exists in int additionMethod(int a, int b)
		// so we can use it directly
		ArithmeticOperation arithmeticOperation2 = MethodReference::additionMethod;
		arithmeticOperation2.printResult(5, 12);
	}
	
	private static int additionMethod(int a, int b) {
		int result = a + b;
		System.out.println("Addition from additionMethod= " + result);
		return result;
	}
	
	private static void instanceMethodObjReference() {
		ArithmeticOperation arithmeticOperation = (a, b) -> {
			int result = a + b;
			System.out.println("Addition from Lamda expression= " + result);
			return result;
		};
		arithmeticOperation.printResult(5, 12);
		// since the logic of the lambda expression exists in int performAadditionMethod(int a, int b)
		// so we can use it directly
		MethodReference methodReference = new MethodReference();
		ArithmeticOperation arithmeticOperation2 = methodReference::performAadditionMethod;
		arithmeticOperation2.printResult(5, 12);
	}
	
	private int performAadditionMethod(int a, int b) {
		int result = a + b;
		System.out.println("Addition from performAadditionMethod= " + result);
		return result;
	}
	
	private static void instanceMethodWithClassName() {
		List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("Show list using Lambda expression: ");
		listInt.forEach(i -> System.out.println(i));
		// since the logic used in the Lambda expression exists in: System.out::print
		// we can use it directly as instanceMethodClassName
		System.out.println("Show list using instanceMethodClassName: ");
		listInt.forEach(System.out::println);
	}
}
