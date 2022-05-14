package com.anchtun.java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperations {

	public static void main(String[] args) {
		mapOperation();
		flatMapOperation();
		filterOperation();
		limit_skip_Operations();
		distinctOperation();
		sortedOperation();
		peekOperation();
	}

	// we use map here to transform each element toUpperCase
	private static void mapOperation() {
		System.out.println("map Operation:");
		List<String> listCars = Arrays.asList("Mercedes", "Bmw", "Audi", "Ford", "Toyota");
		// map: is an intermediate operation: mean process the data and return a new Stream but not close the Stream
		// forEach: is a terminal operation.
		listCars.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
	}
	
	// flatMap we use it when we have multiple Streams to get ONLY ONE Stream 
	private static void flatMapOperation() {
		System.out.println("flatMap Operation:");
		String[] arrayOfNames = { "Mohamed", "Aymen" };
		Stream<String> streamOfNames = Arrays.stream(arrayOfNames);
		streamOfNames.map(s -> s.split("")) // returns Stream<String[]>
		// flatMap is an intermediate operation
		.flatMap(Arrays::stream)// // returns Stream<String>
		.forEach(System.out::println);
		
		// second example: difference between map and flatMap
		List<List<String>> listNames = Arrays.asList(Arrays.asList("Mohamed"), Arrays.asList("Aymen"));
		// map process two lists
		listNames.stream().map(Collection::stream).forEach(System.out::println);
		// flatMap convert to only one list
		listNames.stream().flatMap(Collection::stream).forEach(System.out::println);
	}
	
	// use filter Operation to filter the names that begins with character 'A' 
	private static void filterOperation() {
		System.out.println("filter Operation:");
		String[] arrayOfNames = { "Mohamed", "Aymen", "Anchtun" };
		Stream<String> streamNames = Arrays.stream(arrayOfNames);
		// filter: is an intermediate operation
		streamNames.filter(s -> s.startsWith("A")).forEach(System.out::println);
	}
		
	private static void limit_skip_Operations() {
		System.out.println("limit/skip Operations:");
		// limit/skip: are an intermediate operations
		// limit
		Stream<Integer> limitStream = Stream.generate(new Random()::nextInt);// will generate infinite numbers
		limitStream.limit(10).forEach(System.out::println);// using limit(10) we will show the first 10 only
		
		// skip
		Stream.iterate(1, n -> n + 1)// will provide infenite number from 1
		.skip(5)// skip first 5
		.limit(22)// get 22 number from 6
		.forEach(System.out::println);
	}
	
	private static void distinctOperation() {
		System.out.println("distinct Operation:");
		String[] arrayOfNames = { "Mohamed", "Aymen", "Anchtun", "Mohamed", "Aymen" };
		Stream<String> streamNames = Arrays.stream(arrayOfNames);
		streamNames.distinct().forEach(System.out::println);
	}
	
	private static void sortedOperation() {
		System.out.println("sorted Operation:");
		String[] arrayOfNames = { "Mohamed", "Aymen", "Anchtun" };
		Stream<String> streamNames = Arrays.stream(arrayOfNames);
		streamNames.sorted().forEach(System.out::println);
	}
	
	// peek generally used for debugging
	private static void peekOperation() {
		System.out.println("peek Operation:");
		String[] arrayOfNames = { "Mohamed", "Aymen", "Anchtun" };
		Stream<String> streamNames = Arrays.stream(arrayOfNames);
		streamNames
		.filter(s -> s.startsWith("A"))
		.peek(a -> System.out.println("find value bigin with A: " + a))
		.collect(Collectors.toList());
	}
	
	
}
