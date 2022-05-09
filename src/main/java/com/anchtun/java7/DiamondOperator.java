package com.anchtun.java7;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DiamondOperator {

	public static void main(String[] args) {
		beforeJava7();
		withJava7();
	}
	
	// before Java 7 we have to create an object with generic type on both side of the expression
	private static void beforeJava7() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Anchtun");
		map.put(2, "Mohamed");
		map.put(3, "Aymen");
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("The value of " + entry.getKey() + " = " + entry.getValue());
		}
	}

	// Java 7 with Diamond Operator, we can create the object without mentioning generic type on right side
	private static void withJava7() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Anchtun");
		map.put(2, "Mohamed");
		map.put(3, "Aymen");
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("The value of " + entry.getKey() + " = " + entry.getValue());
		}
	}
}
