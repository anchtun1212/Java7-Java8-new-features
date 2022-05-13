package com.anchtun.java8.functionalinterface;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;

// there is no AutoBoxing
public interface PrimitiveFunctionalInterface {

	public static void main(String[] args) {
		problemWithNormalFunctionalInterfaces();
		predicatePrimitiveFunctions();
		functionPrimitiveFunctions();
		biFunctionPrimitiveFunctions();
		consumerPrimitiveFunctions();
		supplierPrimitiveFunctions();
		unaryPrimitiveFunctions();
		binaryPrimitiveFunctions();
	}
	
	private static void problemWithNormalFunctionalInterfaces() {
		// Creating a function
		// 1) First the input value provided will be converted to Integer using AutoBoxing
		// 2) Second the input value provided to the method body will be converted to int
		// using Auto unboxing during business logic: (a * 2)
		// 3) Finally after Business logic the return value has to be converted to Integer using AutoBoxing
		Function<Integer, Integer> doubleTheValue = a -> a * 2;
		int[] firstArray = { 1, 2, 3, 4, 5 };
		int[] finalArray = new int[firstArray.length];
		for (int i = 0; i < finalArray.length; i++) {
			finalArray[i] = doubleTheValue.apply(firstArray[i]);
		}
		System.out.println("First array: " + Arrays.toString(firstArray));
		System.out.println("Final array: " + Arrays.toString(finalArray));
	}
	
	// there is no AutoBoxing
	private static void predicatePrimitiveFunctions() {
		IntPredicate isIntEven = a -> a % 2 == 0;
		System.out.println("Is 5 even: " + isIntEven.test(5));
		DoublePredicate isDoubleEven = a -> a % 2 == 0;
		System.out.println("Is 5.00 even: " + isDoubleEven.test(5.00F));
		LongPredicate isLongEven = a -> a % 2 == 0;
		System.out.println("Is 1500000.00 even: " + isLongEven.test(1500000L));
	}
	
	private static void functionPrimitiveFunctions() {
		IntFunction<String> convertInt = a -> Integer.toString(a);
		System.out.println("convertInt: " + convertInt.apply(5));
		DoubleFunction<String> convertDouble = a -> Double.toString(a);
		System.out.println("convertDouble: " + convertDouble.apply(5.00));
		LongFunction<String> convertLong = a -> Long.toString(a);
		System.out.println("convertLong: " + convertLong.apply(1500000));

		ToIntFunction<String> toInt = a -> Integer.parseInt(a);
		System.out.println("toInt: " + toInt.applyAsInt("5"));
		ToDoubleFunction<String> toDouble = a -> Double.parseDouble(a);
		System.out.println("toDouble: " + toDouble.applyAsDouble("5.0"));
		ToLongFunction<String> toLong = a -> Long.parseLong(a);
		System.out.println("toLong: " + toLong.applyAsLong("1500000"));

		IntToDoubleFunction intToDouble = a -> (double) a;
		System.out.println("intToDouble: " + intToDouble.applyAsDouble(5));
		IntToLongFunction intToLong = a -> (long) a;
		System.out.println("intToLong: " + intToLong.applyAsLong(5));
		LongToIntFunction longToInt = a -> (int) a;
		System.out.println("longToInt: " + longToInt.applyAsInt(1500000));
		LongToDoubleFunction logToDouble = a -> (double) a;
		System.out.println("logToDouble: " + logToDouble.applyAsDouble(1500000));
		DoubleToIntFunction doubleToInt = a -> (int) a;
		System.out.println("doubleToInt: " + doubleToInt.applyAsInt(5.00));
		DoubleToLongFunction doubleToLong = a -> (long) a;
		System.out.println("doubleToLong: " + doubleToLong.applyAsLong(5.00));
	}
	
	private static void biFunctionPrimitiveFunctions() {
		ToIntBiFunction<String, String> toIntBiFunction = (a, b) -> Integer.parseInt(a) + Integer.parseInt(b);
		System.out.println("toIntBiFunction: " + toIntBiFunction.applyAsInt("5", "12"));
		ToLongBiFunction<String, String> toLongBiFunction = (a, b) -> Long.parseLong(a) + Long.parseLong(b);
		System.out.println("toLongBiFunction: " + toLongBiFunction.applyAsLong("5000000", "12000000"));
		ToDoubleBiFunction<String, String> toDoubleBiFunction = (a, b) -> Double.parseDouble(a) + Double.parseDouble(b);
		System.out.println("toDoubleBiFunction: " + toDoubleBiFunction.applyAsDouble("5.00", "12.00"));
	}
	
	private static void consumerPrimitiveFunctions() {
		IntConsumer intConsumer = a -> System.out.println("intConsumer= " + a);
		intConsumer.accept(5);
		LongConsumer longConsumer = a -> System.out.println("longConsumer= " + a);
		longConsumer.accept(1500000);
		DoubleConsumer doubleConsumer = a -> System.out.println("doubleConsumer= " + a);
		doubleConsumer.accept(5.00);

		ObjIntConsumer<String> objIntConsumer = (i, a) -> System.out.println("objIntConsumer= " + i + a);
		objIntConsumer.accept("Aymen", 5);
		ObjLongConsumer<String> objLongConsumer = (i, a) -> System.out.println("objLongConsumer= " + i + a);
		objLongConsumer.accept("Anchtun", 15000000);
		ObjDoubleConsumer<String> objDoubleConsumer = (i, a) -> System.out.println("objDoubleConsumer= " + i + a);
		objDoubleConsumer.accept("Mohamed", 5.00);
	}
	
	private static void supplierPrimitiveFunctions() {
		IntSupplier intSupplier = () -> 5;
		System.out.println("intSupplier= " + intSupplier.getAsInt());
		LongSupplier longSupplier = () -> 1500000;
		System.out.println("longSupplier= " + longSupplier.getAsLong());
		DoubleSupplier doubleSupplier = () -> 5.00;
		System.out.println("doubleSupplier= " + doubleSupplier.getAsDouble());
		BooleanSupplier booleanSupplier = () -> LocalDate.now().isLeapYear();
		System.out.println("booleanSupplier; isLeapYear? " + booleanSupplier.getAsBoolean());
	}
	
	private static void unaryPrimitiveFunctions() {
		IntUnaryOperator intUnary = a -> a * 2;
		System.out.println("intUnary= " + intUnary.applyAsInt(5));
		LongUnaryOperator longUnary = a -> a / 2;
		System.out.println("longUnary= " + longUnary.applyAsLong(15000000));
		DoubleUnaryOperator doubleUnary = a -> a * 2;
		System.out.println("doubleUnary= " + doubleUnary.applyAsDouble(5));
	}

	private static void binaryPrimitiveFunctions() {
		IntBinaryOperator intBinary = (a, b) -> a + b;
		System.out.println("intBinary= " + intBinary.applyAsInt(5, 12));
		LongBinaryOperator longBinary = (a, b) -> a / b;
		System.out.println("longBinary= " + longBinary.applyAsLong(15000000, 2));
		DoubleBinaryOperator doubleBinary = (a, b) -> a * b;
		System.out.println("doubleBinary= " + doubleBinary.applyAsDouble(5, 12));
	}
	
}
