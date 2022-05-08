package com.anchtun.java7;

import java.util.Objects;

/**
 * 
 * java.util.Objects consists of utility static methods for operating on objects.
 * Those methods include null checks, computing hasCode, comparing two objects, returning a String for an Object.
 * Have two methods:
 * requireNonNull(T obj): will throw NullPointerException if the object is null
 * requireNonNull(T obj, String message): you can customize the error message
 */
public class NewObjectsClass {

	public static void main(String[] args) {
		String name = "Anchtun";
		//String name = null;
		Objects.requireNonNull(name, "Name should not be null");
		// try always to use the toString method from Objects class
		System.out.println("Name=" + Objects.toString(name));
	}
}
