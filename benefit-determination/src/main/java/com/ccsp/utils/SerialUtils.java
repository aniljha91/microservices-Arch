package com.ccsp.utils;

import com.google.gson.Gson;

/**
 * 
 * @author rbongurala
 *
 */
public class SerialUtils {
	SerialUtils(){
		
	}

	public static String serializeObject(Object o) {
		Gson gson = new Gson();
		return gson.toJson(o);
	}


	public static Object unserializeObject(String s, Object o) {
		Gson gson = new Gson();
		return gson.fromJson(s, o.getClass());
	}

	public static Object cloneObject(Object o) {
		String s = serializeObject(o);
		return unserializeObject(s, o);
	}
}
