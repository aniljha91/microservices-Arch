package com.org.common.util;

import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;

public class Utils {

	private static List<String> isoCountryCodeList = Lists.newArrayList(Locale.getISOCountries());
	
	public static boolean isValidCountryCode(String countryCode) {
		return countryCode != null && isoCountryCodeList.contains(countryCode);
	}
}
