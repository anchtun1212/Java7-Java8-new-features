package com.anchtun.java7;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @SafeVarargs annotation can be applied only on: final methods/ static methods/ constructors 
 * Is used to indicate that methods will not cause heap pollution
 *
 */
public class SafeVarargsAnnotation {

	public static void main(String[] args) {
		int a = 13;
		int b = 5;
		int c = 22;
		int d = 30;
		int numArray[] = { a, b, c, d };
		sum(numArray);
		sum(a, b);
		sum(a, b, c);
		sum(a, c, d);

		List<String> elm1 = new ArrayList<String>();
		elm1.add("Anchtun");
		List<String> elm2 = new ArrayList<String>();
		elm1.add("Mohamed");
		List<String> elm3 = new ArrayList<String>();
		elm1.add("Aymen");
		print(elm1, elm2, elm3);
	}

	private static void sum(int... numbers) {
		int totalSum = 0;
		for (int i = 0; i < numbers.length; i++) {
			totalSum = totalSum + numbers[i];
		}
		System.out.println("sum=" + totalSum);
	}

	// indicate to the compiler that I am sure there is no heap pollution or possibility of ClassCastException
	// also need to remove the code that can cause this heap pollution 
	@SafeVarargs
	public static final void print(List<String>... msgs) {
		// can cause this heap pollution
		/*Object[] arr = msgs;
		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(1308);
		arr[0] = listInt;
		// will cause ClassCastException*/
		// the heap now is polluted because we have Integers and String in the same Object[]
		String firstElement = msgs[0].get(0);
		System.out.println("First element=" + firstElement);
	}
}
