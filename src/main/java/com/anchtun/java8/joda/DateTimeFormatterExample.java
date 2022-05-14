package com.anchtun.java8.joda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterExample {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2021, 8, 22);
		String baseISO = date.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("baseISO= " + baseISO);
		String localISO = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("localISO= " + localISO);

		LocalDate baseISOdate = LocalDate.parse("20210822", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("baseISOdate= " + baseISOdate);
		LocalDate localISOdate = LocalDate.parse("2021-08-22", DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("localISOdate= " + localISOdate);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.of(2021, 5, 27);
		String formattedDate = formatter.format(localDate);
		System.out.println("formattedDate= " + formattedDate);

		DateTimeFormatter germanFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.GERMAN);
		LocalDate germanLocalDate = LocalDate.of(2021, 12, 3);
		String germanFormattedDate = germanFormatter.format(germanLocalDate);
		System.out.println("germanFormattedDate= " + germanFormattedDate);
	}
}
