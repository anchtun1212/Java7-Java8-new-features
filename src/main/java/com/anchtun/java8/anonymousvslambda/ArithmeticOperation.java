package com.anchtun.java8.anonymousvslambda;

// this annotation is optional; just to help you to know that this interface is a Functional Interface
//but when we add it the compiler avoid you to add two abstract methods
@FunctionalInterface
public interface ArithmeticOperation {

	int printResult(int a, int b);

}
