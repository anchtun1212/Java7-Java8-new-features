package com.anchtun.java8.joda;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;

public class JodaExample {

	public static void main(String[] args) {
		localDate();
		localTime();
		localDateTime();
		instant_duration_period();
	}
	
	// we can use this when we care only about the date but not care about the time
	private static void localDate() {
		LocalDate toDay = LocalDate.now();
		System.out.println("today is = " + toDay);
		LocalDate date = LocalDate.of(2022, 4, 17);// the month start with 1 not like java.util.Date that the month start with 0
		System.out.println("date = " + date);
		int year1 = date.getYear();
		System.out.println("year1 = " + year1);
		int year2 = date.get(ChronoField.YEAR);
		System.out.println("year2 = " + year2);
		Month month1 = date.getMonth();
		System.out.println("month1 = " + month1);
		int month2 = date.get(ChronoField.MONTH_OF_YEAR);
		System.out.println("month2 = " + month2);
		int day1 = date.getDayOfMonth();
		System.out.println("day1 = " + day1);
		int day2 = date.get(ChronoField.DAY_OF_MONTH);
		System.out.println("day2 = " + day2);
		DayOfWeek dow = date.getDayOfWeek();
		System.out.println("dow = " + dow);
		int len = date.lengthOfMonth();
		System.out.println("length of month = " + len);
		boolean leap = date.isLeapYear();
		System.out.println("is this year leap = " + leap);
		LocalDate parseDate = LocalDate.parse("2021-09-23");
		System.out.println("parseDate year is: " + parseDate.getYear());
	}
	
	// we can use this when we care only about the time but not care about the date
	private static void localTime() {
		LocalTime timeNow = LocalTime.now();
		System.out.println("Now: " + timeNow);
		LocalTime time = LocalTime.of(19, 11, 50);
		System.out.println("Time choosen by user is: " + time);
		int hour = time.getHour();
		System.out.println("Hour choosen by user is: " + hour);
		int minute = time.getMinute();
		System.out.println("Minute choosen by user is: " + minute);
		int second = time.getSecond();
		System.out.println("Second choosen by user is: " + second);
		LocalTime parseTime = LocalTime.parse("06:09:45");
		System.out.println("parseTime hour= " + parseTime.getHour());
	}
	
	// use both date and time
	private static void localDateTime() {
		LocalDateTime dateTime2 = LocalDateTime.of(2021, 6, 15, 18, 00, 40);
		System.out.println("dateTime2= " + dateTime2);

		LocalDate date2 = dateTime2.toLocalDate();
		System.out.println("date2= " + date2);
		LocalTime time2 = dateTime2.toLocalTime();
		System.out.println("time2= " + time2);

		LocalDate date = LocalDate.of(2022, 4, 17);
		LocalTime time = LocalTime.of(19, 11, 50);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println("dateTime= " + dateTime);

		System.out.println("DayOfMonth= " + dateTime.getDayOfMonth());
		System.out.println("DayOfYear= " + dateTime.getDayOfYear());
		System.out.println("hour= " + dateTime.getHour());
		System.out.println("minute= " + dateTime.getMinute());
		System.out.println("month= " + dateTime.getMonthValue());
		System.out.println("nano= " + dateTime.getNano());
		System.out.println("second= " + dateTime.getSecond());
		System.out.println("year= " + dateTime.getYear());
		System.out.println("DayOfWeek= " + dateTime.getDayOfWeek());
		System.out.println("isAfter= " + dateTime.isAfter(dateTime2));
		System.out.println("isBefore= " + dateTime.isBefore(dateTime2));
		System.out.println("plus 1 year= " + dateTime.plusYears(1));
		System.out.println("plus 3 months= " + dateTime.plusMonths(3));
		System.out.println("minus 7 months= " + dateTime.minusMonths(7));
		System.out.println("minus 5 week= " + dateTime.minusWeeks(5));
	}
	
	private static void instant_duration_period() {
		// Instant
		// the time is calculated based on number of seconds passed from the unix epoch time
		// , set by convention to midnight of 01-01-1970
		Instant instant = Instant.ofEpochSecond(51290900);
		System.out.println("instant= " + instant);
		System.out.println("Instant.ofEpochSecond(5, 1_000)= " + Instant.ofEpochSecond(5, 1_000));
		System.out.println("Instant.ofEpochSecond(5, -1_000)= " + Instant.ofEpochSecond(500000000, -1_000));
		Instant now = Instant.now();
		System.out.println("Now= " + now);
		
		// Duration: used to identify the duration between two instances
		Duration instantDuration = Duration.between(instant, now);
		System.out.println("instantDuration= " + instantDuration);
		LocalTime time1 = LocalTime.of(13, 9, 50);
		LocalTime time2 = LocalTime.of(18, 45, 23);
		System.out.println("timeDuration= " + Duration.between(time1, time2).toHours() + " Hours");
		LocalDateTime localDateTime1 = LocalDateTime.of(2021, Month.DECEMBER, 12, 12, 34, 13);
		LocalDateTime localDateTime2 = LocalDateTime.of(2022, Month.MARCH, 9, 23, 9, 45);
		System.out.println("localDatetimeDuration= " + Duration.between(localDateTime1, localDateTime2).toDays() + " Days");
		
		// Since LocalDate will not have time associated on it, we use Period to find the number of days difference
		// between two LocalDate objects
		LocalDate date1 = LocalDate.of(2022, 5, 1);
		LocalDate date2 = LocalDate.of(2022, 5, 12);
		Period period = Period.between(date1, date2);
		System.out.println("period= " + period.getDays() + " Days");
	}
	
}
