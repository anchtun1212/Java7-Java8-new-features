package com.anchtun.java8.lambdaexpression;

public class LambdaExamples {

	// for Functional interface you don't have to override we you want to implement the logic
	public static void main(String[] args) {
		voidMethodWithNoParams();
		voidMethodWithOneParam();
		voidMethodWithTwoParams();
		ReturnMethodWithTwoParams();
	}

	private static void voidMethodWithNoParams() {
		// because VoidMethodWithNoParams have only one abstract method, so we can
		// ignore return modifiers, type, methodName, () because there is nor parameters in the abstract method
		// -> used to say to the developers its a Lambda expression
		// if we have more than one statement we can use {} else if we have only one statement we can remove {}
		// you can create many logic for one functional interface in the same class, and we can create many objects
		VoidMethodWithNoParams method1 = () -> {
			// with {}
			System.out.println("Ashhad an la Ilaha illa Allah, wa ashhad anna Mohammed rasul Allah. with {}");
		};

		// // without {}
		VoidMethodWithNoParams method2 = () -> System.out
				.println("Ashhad an la Ilaha illa Allah, wa ashhad anna Mohammed rasul Allah. without {}");

		method1.sayAlShahadatan();
		method2.sayAlShahadatan();
	}
	
	private static void voidMethodWithOneParam() {
		// here the (input) is the parameter of the abstract method in VoidMethodWithOneParam
		// if there is only one param we can remove parenthesis () and write the parameter only in the right side
		VoidMethodWithOneParam method1 = (input) -> {
			System.out.println("Input lowerCase is: " + input.toLowerCase());
		};
		VoidMethodWithOneParam method2 = input -> System.out.println("Input upperCase is: " + input.toUpperCase());
		method1.printWord("Anchtun");
		method2.printWord("Mohamed");
	}
	
	private static void voidMethodWithTwoParams() {
		VoidMethodWithTwoParams method1 = (a, b) -> System.out
				.println("Multiplication of " + a + " and " + b + " is: " + a * b);
		VoidMethodWithTwoParams method2 = (a, b) -> {
			int result = a + b;
			System.out.println("Addition of " + a + " and " + b + " is: " + result);
		};

		method1.printResult(5, 12);
		method2.printResult(5, 12);
	}
	
	private static void ReturnMethodWithTwoParams() {
		// when you use {}: mean multiple statements you should write the keyword return
		ReturnMethodWithTwoParams method1 = (a, b) -> {
			return (a + b);
		};
		ReturnMethodWithTwoParams method2 = (a, b) -> a * b;

		int c = 13;
		int d = 22;
		System.out.println("Addition of " + c + " and " + d + " is: " + method1.printResult(c, d));
		System.out.println("Multiplication of " + c + " and " + d + " is: " + method2.printResult(c, d));
	}

}
