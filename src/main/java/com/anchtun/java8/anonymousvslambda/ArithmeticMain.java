package com.anchtun.java8.anonymousvslambda;

public class ArithmeticMain {

	public static void main(String[] args) {
		int c = 5;
		int d = 12;

		// anonymous class: works with interfaces that have many abstract methods
		// its anonymous inner class without name
		ArithmeticOperation arthOpt1 = new ArithmeticOperation() {
			@Override
			public int printResult(int a, int b) {
				return a + b;
			}
		};

		System.out.println("Result of addition using anonymous class is: " + arthOpt1.printResult(c, d));

		// lambda expression: works with functional interfaces only
		// its anonymous method without name
		ArithmeticOperation arthOpt2 = (a, b) -> a + b;
		System.out.println("Result of addition using lambda expression is: " + arthOpt2.printResult(c, d));

	}
}
