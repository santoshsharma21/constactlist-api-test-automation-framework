/**
 * 
 */
package com.contactslist.api.applicationapi;

import com.contactslist.api.restutilities.HttpRequest;
import com.contactslist.api.routes.Endpoints;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class UserApi {

//	public static Response post(Object payload) {
//		return HttpRequest.post(Endpoints.ADD_USER, payload);
//	}

	public static Response post(boolean addUser, boolean logIn, Object payload) {
		Response response = null;

		if (addUser == true) {
			response = HttpRequest.post(Endpoints.ADD_USER, payload);
		} else if (logIn) {
			response = HttpRequest.post(Endpoints.LOGIN_USER, payload);
		}
		return response;
	}

	public static Response post(String token) {
		return HttpRequest.post(Endpoints.LOGOUT_USER, token);
	}

	public static Response get(String token) {
		return HttpRequest.get(Endpoints.USER_PROFILE, token);
	}

	public static Response patch(String token, Object payload) {
		return HttpRequest.patch(Endpoints.UPDATE_USER, token, payload);
	}

}
