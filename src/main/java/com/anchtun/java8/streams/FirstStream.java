package com.anchtun.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Collections: Will always hold the data of the elements (physical holding of the elements)
 * Streams: Just representation of the element (Store the data inside Stream pool memory location that we have inside Java)
 */
public class FirstStream {

	public static void main(String[] args) {
		List<Integer> favoriteNumbers = Arrays.asList(5, 12, 13, 22, 8);
		// show numbers
		System.out.println("Show numbers using Collection:");
		favoriteNumbers.forEach(System.out::println);

		// Convert favoriteNumbers list to Stream
		Stream<Integer> favoriteNumbersStream = favoriteNumbers.stream();
		System.out.println("Show numbers using stream():");
		favoriteNumbersStream.forEach(System.out::println);

		// Convert favoriteNumbers list to parallelStream
		Stream<Integer> favoriteNumbersParralelStream = favoriteNumbers.parallelStream();
		System.out.println("Show numbers using parallelStream():");
		favoriteNumbersParralelStream.forEach(System.out::println);

		// use Stream.of(T)
		Stream<Integer> favoriteNumbersOfStream = Stream.of(5, 12, 13, 22, 8);
		System.out.println("Show numbers using Stream.of(T):");
		favoriteNumbersOfStream.forEach(System.out::println);

		// create empty Stream
		Stream<Integer> emptyStream = Stream.empty();
		System.out.println("empty Stream:");
		emptyStream.forEach(System.out::println);

		// create Stream from Array
		Integer[] fullArray = { 5, 12, 13, 22, 8 };
		Stream<Integer> streamFromArray = Arrays.stream(fullArray);
		System.out.println("Show numbers using Arrays.stream(fullArray):");
		streamFromArray.forEach(System.out::println);

		// create Stream from Part of Array
		Integer[] partOfArray = { 5, 12, 13, 22, 8 };
		Stream<Integer> streamFromPartOfArray = Arrays.stream(partOfArray, 2, 5);
		System.out.println("Show numbers using Arrays.stream(partOfArray, from, to):");
		streamFromPartOfArray.forEach(System.out::println);

		// generate an infinite stream of element
		//Supplier<Integer> supplier = () -> 512;
		//Stream<Integer> streamInfiniteGenerate = Stream.generate(supplier);
		//System.out.println("Show numbers using Stream.generate (generate an infinite stream of element):");
		//streamInfiniteGenerate.forEach(System.out::println);
		
		// iterate infinite elements
		//UnaryOperator<Integer> multiplyBy5 = input -> input*5;
		//multiplyBy5.apply(5);
		//Stream<Integer> streamIterate = Stream.iterate(2, multiplyBy5);
		//System.out.println("Show numbers using Stream.iterate:");
		//streamIterate.forEach(System.out::println);
	}

}
