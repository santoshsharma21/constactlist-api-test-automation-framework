/**
 * 
 */
package com.contactslist.api.utilities;

import org.json.JSONObject;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtilities {

	// return string from json object response
	public static String getStringFromJsonObj(Response response, String key) {
		String str = response.jsonPath().getString(key);
		return str;
	}

	// returns string value from inner json object
	public static String getStringFromInnerJsonObj(Response response, String innerJsonObj ,String key) {
		JSONObject obj = new JSONObject(response.asString());
		String str = obj.getJSONObject(innerJsonObj).getString(key);
		return str;
	}

}
