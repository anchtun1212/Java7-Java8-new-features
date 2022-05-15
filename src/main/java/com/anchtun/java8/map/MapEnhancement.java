package com.anchtun.java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Bellow are the few important enhancements happened for Map:
 * 1) forEach(): you can iterate the map values easily.
 * 2) Entry.comparingByValue(): Sorting the map elements based on value.
 * 3) Entry.comparingByKey(): Sorting the map elements based on key.
 * 4) getOrDefault: Can be used to pass a default value instead of null if the key is not present.
 * 5) computeIfAbsent: Can be used to calculate a value if there is no given key.
 * 6) computeIfPresent: If the specified key is present, calculate a new value for it.
 * 7) compute: Calculates a new value for a given key and stores it in the Map.
 * 8) remove(key, value): To remove a map element if both key & value matches.
 * 9) replace: For replacement of values if the key present.
 * 10) replaceAll: For replacement of all values inside the map. 
 */
public class MapEnhancement {

	public static void main(String[] args) {

		// forEach()
		System.out.println("*******forEach()*******");
		Map<String, String> map = new HashMap<>();
		map.put("Tunisia", "Tunis");
		map.put("Saudi arabia", "Riyad");
		map.put("Palestine", "AlQuds");
		map.put("Algeria", "Algeria");
		map.put("Egypt", "Cairo");
		map.put("Emirates", "Dhabi");
		map.put("Italy", "Roma");
		map.put("Morroco", "Casablanca");
		map.forEach((country, capital) -> System.out.println(capital + " is the capital of " + country));

		// Entry.comparingByValue()
		System.out.println("*******comparingByValue*******");
		map.entrySet().stream().sorted(Entry.comparingByValue()).forEach(System.out::println);

		// Entry.comparingByKey()
		System.out.println("*******comparingByKey*******");
		map.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);

		// getOrDefault
		System.out.println("*******getOrDefault*******");
		System.out.println(map.getOrDefault("Israel", "No data present... Do you mean Palestine?"));

		// computeIfAbsent
		map.computeIfAbsent("Libya", name -> "Trables");

		// computeIfPresent
		map.computeIfPresent("Libya", (k, v) -> "Tripoli");

		// compute
		map.compute("Emirates", (k, v) -> "Abu " + v);

		// remove(key, value)
		map.remove("Italy", "Roma");

		// replace
		map.replace("Morroco", "Rabat");

		// replaceAll
		map.replaceAll((k, v) -> v.toUpperCase());

		// last print of map after changes
		System.out.println("*******map after changes*******");
		map.forEach((country, capital) -> System.out.println(capital + " is the capital of " + country));
	}
}
