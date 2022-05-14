package com.anchtun.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOperations {

	public static void main(String[] args) {
		reduceOperation();
		collectOperation();
		collectingAndThenOperation();
		groupingByOperation();
		partitioningByOperation();
	}

	private static void reduceOperation() {
		System.out.println("Reduce Operation: ");
		// reduce will calculate the SUM of the first 5 elements: 0 + 1 + 2 + 3 + 4
		System.out.println(Stream.iterate(0, n -> n + 1).limit(5).reduce(0, (a, b) -> a + b));
		// reduce will calculate the MULTIPLICATION of the first 5 elements: 1 * 2 * 3 * 4 * 5
		System.out.println(Stream.iterate(1, n -> n + 1).limit(5).reduce(1, (a, b) -> a * b));
	}
	
	private static void collectOperation() {
		System.out.println("Collect Operation: ");
		List<String> listName = Arrays.asList("Mohamed", "Aymen", "Anchtun");
		System.out.println("List names begin with A: ");
		List<String> listNameBeginWithA = listName.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
		listNameBeginWithA.forEach(System.out::println);
		String listNameJoined = listName.stream().collect(Collectors.joining());
		System.out.println("listNameJoined= " + listNameJoined);
	}
		
	private static void collectingAndThenOperation() {
		System.out.println("CollectingAndThen Operation: ");
		List<Product> listProduct = new ArrayList<>();
		listProduct.add(new Product("Iphone 12", 2500));
		listProduct.add(new Product("Iphone 13", 3500));
		listProduct.add(new Product("samsung s22 ultra", 3000));
		String productName = listProduct
				.stream()
				.collect(Collectors.collectingAndThen(
								Collectors.minBy(Comparator.comparing(Product::getPrice))
								, (Optional<Product> p) -> p.isPresent() ? p.get().getName() : "Emplty"
						));
		System.out.println("The product that have the mininum price is: " + productName);
	}
	
	private static void groupingByOperation() {
		System.out.println("groupingByOperation Operation: ");
		List<Product> listProduct = new ArrayList<>();
		listProduct.add(new Product("Iphone 12", 2500));
		listProduct.add(new Product("Iphone 13", 3500));
		listProduct.add(new Product("samsung s22 ultra", 3000));
		listProduct.add(new Product("Nokia", 2500));
		listProduct.add(new Product("Huawei", 2500));
		listProduct.add(new Product("LG", 3000));
		listProduct.add(new Product("Motorola", 2500));
		listProduct.add(new Product("HTC", 3300));
		listProduct.add(new Product("OPPO", 3000));
		Map<Double, List<Product>> mapProduct = listProduct.stream().collect(Collectors.groupingBy(Product::getPrice));
		System.out.println("List of product grouped by price: " + mapProduct);
	}
	
	private static void partitioningByOperation() {
		System.out.println("partitioningBy Operation: ");
		List<Product> listProduct = new ArrayList<>();
		listProduct.add(new Product("Iphone 12", 2500));
		listProduct.add(new Product("Iphone 13", 3500));
		listProduct.add(new Product("samsung s22 ultra", 3000));
		listProduct.add(new Product("Nokia", 2500));
		listProduct.add(new Product("Huawei", 2500));
		listProduct.add(new Product("LG", 3000));
		listProduct.add(new Product("Motorola", 2500));
		listProduct.add(new Product("HTC", 3300));
		listProduct.add(new Product("OPPO", 3000));
		// compared to filters, Partitioning has the advantage of keeping both lists of the stream elements
		// , for which the application of the partitioning function return true or false
		Map<Boolean, List<Product>> mapProduct = listProduct.stream().collect(Collectors.partitioningBy(p -> p.getPrice() > 3000));
		System.out.println("List of product grouped by price > 3000: " + mapProduct.get(true));
		System.out.println("List of product grouped by price <= 3000: " + mapProduct.get(false));
	}
}
