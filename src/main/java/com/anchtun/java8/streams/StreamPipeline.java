package com.anchtun.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * We can form a chain of stream operations using intermediate and terminal operations to achieve a desire output.
 * This we also call as stream pipeline
 */
public class StreamPipeline {

	public static void main(String[] args) {
		List<Integer> listInt = Arrays.asList(1, 5, 8, 13, 22, 30);
		List<Integer> listOddMultiplySorted = listInt.stream()// create a stream
				.filter(i -> i % 2 != 0)// get odd numbers
				.map(i -> i * i)// Multiply numbers by them selves: example: (13*13)
				.sorted()//sort the numbers
				.collect(Collectors.toList());// return new List
		listOddMultiplySorted.forEach(System.out::println);
	}

}
