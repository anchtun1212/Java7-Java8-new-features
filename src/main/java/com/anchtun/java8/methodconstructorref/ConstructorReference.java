package com.anchtun.java8.methodconstructorref;

public class ConstructorReference {

	public static void main(String[] args) {
		ProductInterface productInterface = (name, price) -> {
			Product product = new Product(name, price);
			return product;
		};
		Product prod1 = productInterface.getProduct("Iphone 13", 3400);
		System.out.println("Product from Lamda expression= " + prod1.toString());

		// we can create new Product Object using ConstructorReference
		ProductInterface productInterface2 = Product::new;
		Product prod2 = productInterface2.getProduct("Iphone 12", 2500);
		System.out.println("Product from ConstructorReference= " + prod2.toString());
	}

}
