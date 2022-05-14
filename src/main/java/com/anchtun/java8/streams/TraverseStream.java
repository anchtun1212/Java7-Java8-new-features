package com.anchtun.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TraverseStream {

	public static void main(String[] args) {
		List<String> listName = Arrays.asList("Mohamed", "Aymen", "Anchtun");
		Stream<String> streamName = listName.stream();
		streamName.forEach(System.out::println);
		//streamName.forEach(System.out::println); // will throw IllegalStateException because the Stream can be traversed ONLY ONCE
	}

}
