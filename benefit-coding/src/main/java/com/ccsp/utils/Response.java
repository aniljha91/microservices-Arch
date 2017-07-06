package com.ccsp.utils;

import com.google.gson.Gson;

public class Response {
	Response(){
	}
	public static String getResponse(Object object){
		Gson gson = new Gson();
		return gson.toJson(object);
	}

}
