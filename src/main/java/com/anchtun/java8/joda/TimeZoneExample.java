package com.anchtun.java8.joda;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeZoneExample {

	public static void main(String[] args) {
		// Tunisia
		ZoneId tunisia = ZoneId.of("Africa/Tunis");
		ZonedDateTime tunisiaZonedDateTime = ZonedDateTime.now(tunisia);
		System.out.println("The time now in Tunisia is: " + tunisiaZonedDateTime);

		// Saudi Arabia
		// convert to different Timezone
		ZonedDateTime riyadhZonedDateTime = tunisiaZonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Riyadh"));
		System.out.println("The time now in Saudi arabia is: " + riyadhZonedDateTime);

		// Tunisia
		ZoneOffset tunisiaOffset = ZoneOffset.of("+01:00");
		OffsetDateTime tunisiaTime = OffsetDateTime.now(tunisiaOffset);
		System.out.println("The time now in Tunisia using offset is: " + tunisiaTime);

		// Saudi Arabia
		OffsetDateTime saudiOffset = tunisiaTime.withOffsetSameInstant(ZoneOffset.of("+03:00"));
		System.out.println("The time now in Saudi arabia using offset is: " + saudiOffset);
	}
}
