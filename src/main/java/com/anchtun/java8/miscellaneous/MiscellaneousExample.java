package com.anchtun.java8.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;

/**
 * new methods in the Collection interfaces & other classes
 * 1) List: replaceAll(), sort
 * 2) Iterator: forEachRemaining
 * 3) Iterate: spliterator, forEach
 * 4) Collection: stream, parallelStream, removeIf
 * 5) Comparator: reversed, thenComparing, naturalOrder, reverseOrder, nullsFirst, nullsLast
 * 6) Arrays: setAll, parallelPrefix, parallelSort, parallelSetAll
 * 7) String: join
 * 8) Math: addExact, subtractExact, multiplyExact, incrementExact, decrementExact, negateExact, toIntExact, floorDiv, floorMod, nextDown
 * 9) Number: sum, min, max are static methods in Short, Integer, Long, Float, Double. Etc.
 * 10) Boolean: logicalAnd, logicalOr, logicalXor
 * 11) Objects: isNull, nonNull
 */
public class MiscellaneousExample {

	public static void main(String[] args) {
		listNews();
		iteratorNews();
		stringJoin();
		arraysNews();
		numberNews();
		mathNews();
		objectsNullCheck();
		booleanMethods();
	}
	
	private static void listNews() {
		System.out.println("*******List*******");
		List<String> list = Arrays.asList("Tunisia", "Saudi arabia", "Qatar", "Algeria", "Libya", "Palestine",
				"Morroco", "Emirates", "Egypt");
		list.replaceAll(name -> name.toUpperCase());
		list.sort(Comparator.naturalOrder());
		// list.sort(Comparator.reverseOrder());
		list.forEach(System.out::println);
	}
	
	private static void iteratorNews() {
		System.out.println("*******iterator*******");
		List<String> list = Arrays.asList("Tunisia", "Saudi arabia", "Qatar", "Algeria", "Libya", "Palestine",
				"Morroco", "Emirates", "Egypt");
		ArrayList<String> newCountryList = new ArrayList<>();
		// spliterator: traverse all the elements one by one in the list
		Spliterator<String> splitList = list.spliterator();
		// iterate the list one by one
		// tryAdvance: if the next element exists then return boolean, else will not execute the logic
		while (splitList.tryAdvance(e -> newCountryList.add(e.toLowerCase())));
		// print the list
		Spliterator<String> splitListToShow = newCountryList.spliterator();
		//while (splitListToShow.tryAdvance(System.out::println));
		splitListToShow.forEachRemaining(System.out::println);
		// show list using forEachRemaining
		System.out.println("*******Show origin list using forEachRemaining*******");
		list.iterator().forEachRemaining(System.out::println);
	}
	
	private static void stringJoin() {
		System.out.println("*******join*******");
		// Join multiple Strings based on the delimiter that you specify
		String countries = String.join(", ", "Tunisia", "Saudi arabia", "Algeria", "Libya", "Palestine");
		System.out.println(countries);
	}
	
	private static void arraysNews() {
		System.out.println("*******arraysNews*******");
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// setAll
		Arrays.setAll(array, e -> {
			return array[e] = array[e] * 2;
		});
		System.out.println(Arrays.toString(array));

		// parallelSort
		int[] parallelSortArray = { 56, 8, 9, 45, 12, 1, 22, 13, 5, 30 };
		Arrays.parallelSort(parallelSortArray);
		System.out.println(Arrays.toString(parallelSortArray));

		// parallelPrefix: to add two consecutive elements in the array
		int[] newArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Arrays.parallelPrefix(newArray, (a, b) -> a + b);
		System.out.println(Arrays.toString(newArray));
		
		// parallelSetAll
		Arrays.parallelSetAll(newArray, e -> {
			return newArray[e] = newArray[e] - 1;
		});
		System.out.println(Arrays.toString(newArray));
	}
	
	private static void numberNews() {
		System.out.println("*******numberNews*******");
		int sum = Integer.sum(30, 5);
		int min = Integer.min(30, 5);
		int max = Integer.max(30, 5);
		System.out.println("Sum = " + sum + " min= " + min + " max= " + max);
	}
	
	private static void mathNews() {
		System.out.println("*******mathNews*******");
		int sum = Math.addExact(12, 33);
		int sub = Math.subtractExact(12, 33);
		int mult = Math.multiplyExact(12, 33);
		int inc = Math.incrementExact(12);
		int dec = Math.decrementExact(13);
		long neg = Math.negateExact(1234567);
		int toInt = Math.toIntExact(1234567);
		int floorDiv = Math.floorDiv(21, 5);
		int floorMod = Math.floorMod(21, 5);
		float nextDown = Math.nextDown(12);
		System.out.println("sum= " + sum + ", sub= " + sub + ", mult= " + mult + ", inc= " + inc + ", dec= " + dec
				+ ", neg= " + neg + ", toInt= " + toInt + ", floorDiv= " + floorDiv + ", floorMod= " + floorMod
				+ ", nextDown= " + nextDown);
	}
	
	private static void objectsNullCheck() {
		System.out.println("*******objectsNullCheck*******");
		List<String> list = Arrays.asList("Tunisia", "Saudi arabia", null, "Qatar", "Algeria", "Libya", "Palestine",
				"Morroco", null, "Emirates", "Egypt", null);
		long numNullObj = list.stream().filter(Objects::isNull).count();
		long numNoNullObj = list.stream().filter(Objects::nonNull).count();
		System.out.println("Null objects= " + numNullObj + ", Non null objects= " + numNoNullObj);
	}
	
	private static void booleanMethods() {
		System.out.println("*******booleanMethods*******");
		// you can use then to increase readability
		Boolean checkAnd = Boolean.logicalAnd(12 > 5, "anchtun".equals("anchtun"));
		Boolean checkOr = Boolean.logicalOr(12 > 5, "anchtun".equals("Aymen"));
		// Xor mean: condition1 OR condition2 BUT NOT THE TWO AT THE SAME TIME
		Boolean checkXor = Boolean.logicalXor(12 > 5, "anchtun".equals("anchtun"));
		Boolean checkXor2 = Boolean.logicalXor(12 > 5, "anchtun".equals("Aymen"));
		System.out.println("checkAnd= " + checkAnd + " , checkOr= " + checkOr + " , checkXor= " + checkXor
				+ " , checkXor2= " + checkXor2);
	}

}
