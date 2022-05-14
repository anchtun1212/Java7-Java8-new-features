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
	}

}
