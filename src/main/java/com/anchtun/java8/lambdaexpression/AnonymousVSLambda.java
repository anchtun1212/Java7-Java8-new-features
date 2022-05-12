package com.anchtun.java8.lambdaexpression;

public class AnonymousVSLambda {

	int sum = 0;
	int minusOne = -1;
	static int statSum = 2;

	public void complexCalculation() {
		int localSum = 0;
		ArithmeticOperation addition = (a, b) -> {
			// we can't change the value local variables 
			//(local variable inside lambda expression acts like final variable; we can use them only)
			// all method local variables are stored in the stack, whereas class instance variable, and static variables
			// are stored in heap
			//localSum = 1;
			int sum = 0;// compile error
			//statSum = statSum + minusOne;// compile error: we can't use minusOne because its not static
			statSum = statSum - 1;// we can change the value of static variables because they are in the heap
			this.sum = statSum + a + b;
			return this.sum;
			// return sum;// will return the sum variable of the class = 0
		};
		System.out.println("The sum is: " + addition.printResult(5, 12));
	}

	public static void main(String[] args) {
		AnonymousVSLambda obj = new AnonymousVSLambda();
		obj.complexCalculation();
	}
}
