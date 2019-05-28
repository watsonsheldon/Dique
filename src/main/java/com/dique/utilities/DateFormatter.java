package com.dique.utilities;

import org.springframework.stereotype.Component;

@Component
public final class DateFormatter {
	public String format(Long target) {

		String yyyyMMddhhmm = String.valueOf(target);

		String yyyy = yyyyMMddhhmm.substring(0, 4);
		String MM = yyyyMMddhhmm.substring(4, 6);
		String dd = yyyyMMddhhmm.substring(6, 8);
		String hh = yyyyMMddhhmm.substring(8, 10);
		String mm = yyyyMMddhhmm.substring(10, 12);

		String date = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm;

		return date;
	}
}
