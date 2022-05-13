package com.anchtun.java8.functionalinterface;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * Will always return a value without accepting any input
 * Thing of the scenario of generating report, or OTP when we don't provide any input
 */
public interface SupplierFunctionalInterface {

	public static void main(String[] args) {

		// creating a supplier
		Supplier<Integer> supplierDay = () -> LocalDate.now().getDayOfMonth();
		System.out.println("The day is: " + supplierDay.get());

		// creating a supplier
		Supplier<Integer> supplierMonth = () -> LocalDate.now().getMonthValue();
		System.out.println("The month is: " + supplierMonth.get());

		// creating a supplier
		Supplier<Integer> supplierYear = () -> LocalDate.now().getYear();
		System.out.println("The year is: " + supplierYear.get());

		System.out.println("So today is: " + supplierDay.get() + "-" + supplierMonth.get() + "-" + supplierYear.get() + " !!!");

	}
}
