package com.anchtun.java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		// will throw NullPointerException
		// beforeJava8();
		withJava8();
	}

	// before Java 8
	public static void beforeJava8() {
		String arr[] = new String[5];
		String str = arr[3].toUpperCase();
		System.out.println("String at index 3: " + str);
	}

	// with Java 8
	public static void withJava8() {
		String arr[] = new String[5];

		arr[1] = "Anchtun";

		// create an empty Object
		Optional<String> empty = Optional.empty();
		System.out.println("Create an empty Object: " + empty);

		// will throw NullPointerException, you should use Optional.of only if you are sure there is a value
		// Optional<String> str2 = Optional.of(arr[2]);

		// Optional.ofNullable will return Object if exists else will return empty Object
		Optional<String> str3 = Optional.ofNullable(arr[3]);
		// this code will be executed only ifPresent: if there is value
		str3.ifPresent(System.out::println);
		// if the value not exists then print: No Value
		System.out.println(str3.orElse("No value"));

		Optional<String> str1 = Optional.ofNullable(arr[1]);
		// will print the value because ifPresent = true
		str1.ifPresent(System.out::println);
		System.out.println("Value at index 1: " + str1.get());

		// not empty Optional
		Optional<String> notEmptyOptional = Optional.of("Mohamed");
		// empty Optional
		Optional<String> emptyOptional = Optional.empty();
		// use map
		System.out.println("notEmptyOptional to UpperCase:" + notEmptyOptional.map(String::toUpperCase));
		// will NOT throw NullPointerException
		System.out.println("emptyOptional to UpperCase:" + emptyOptional.map(String::toUpperCase));

		// use Optional twice
		Optional<Optional<String>> doubleNotEmptyOptional = Optional.of(Optional.of("Mohamed"));
		System.out.println("doubleNotEmptyOptional value: " + doubleNotEmptyOptional);
		System.out.println("doubleNotEmptyOptional map: " + doubleNotEmptyOptional.map(input -> input.map(String::toUpperCase)));
		// flatMap: flat on multiple layers of Optional
		System.out.println("doubleNotEmptyOptional flatMap: "+ doubleNotEmptyOptional.flatMap(input -> input.map(String::toUpperCase)));

		// create Optional for countries
		Optional<String> country = Optional.of("Tunisia");
		// empty Optional
		Optional<String> emptyCountry = Optional.empty();

		// filter on Optional
		System.out.println(country.filter(i -> i.equals("tunisia")));// empty Optional
		System.out.println(country.filter(i -> i.equalsIgnoreCase("tunisia")));// Optional[Tunisia]
		System.out.println(emptyCountry.filter(i -> i.equalsIgnoreCase("tunisia")));// empty Optional

		// isPresent: return true if resent else return false
		if (country.isPresent()) {
			System.out.println("Ah nice you are from: " + country.get());
		}

		// we can create two lambda expressions for each case
		country.ifPresentOrElse(
				v -> System.out.println("Your country is:" + v),
				() -> System.out.println("There is no country"));

		// ifPresent: will execute a given method if present
		country.ifPresent(c -> System.out.println("Hello! again you country is: " + c));
		// will not print anything
		emptyCountry.ifPresent(c -> System.out.println("Hello! again you country is: " + c));

		// if there is no country print: There is no country!
		System.out.println(country.orElse("There is no country!"));
		System.out.println(emptyCountry.orElse("There is no country!"));

		// if there is no country print: Then print the value: then execute this lambda method
		System.out.println(emptyCountry.orElseGet(() -> "There is no country!"));
		// will throw: java.util.NoSuchElementException
		//System.out.println(emptyCountry.orElseThrow());
		// will throw: java.util.NoSuchElementException
		System.out.println(emptyCountry.orElseThrow(NoSuchElementException::new));

	}
}
