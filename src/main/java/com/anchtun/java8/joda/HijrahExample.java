package com.anchtun.java8.joda;

import java.time.chrono.HijrahDate;

public class HijrahExample {

	public static void main(String[] args) {
		HijrahDate now = HijrahDate.now();
		System.out.println("Today is: " + now);
	}

}
