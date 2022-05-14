package com.anchtun.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {

	public static void main(String[] args) {
		System.out.println("Sequential stream to Parallel Stream");
		List<String> listCars = Arrays.asList("Mercedes", "Bmw", "Audi", "Ford", "Toyota", "Ferrari", "Bentley", "Cadillac", "Chevrolet", "Kia");

		// use parallel() to convert sequential stream to parallel stream
		listCars.stream().parallel().forEach(System.out::println);

		// use parallelStream()
		System.out.println("Use parallelStream()");
		Stream<String> parallelStreamCars = listCars.parallelStream();
		parallelStreamCars.forEach(System.out::println);
	}
}
