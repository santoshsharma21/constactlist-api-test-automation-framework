/**
 * 
 */
package com.contactslist.api.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.contactslist.api.applicationapi.UserApi;
import com.contactslist.api.payload.UserPayload;
import com.contactslist.api.pojos.User;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class UserApiTests {
	
	@Test(priority = 0)
	public void addNewUser(ITestContext context) {
		// get request payload
		User newUserPayload = UserPayload.newUserPayload();
		// call request
		Response response = UserApi.post(true, false, newUserPayload);
		// get and store token
		String bearertoken = response.jsonPath().getString("token");
		context.setAttribute("token", bearertoken);
		// validate response
		Assert.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(priority = 1)
	public void getUserProfile(ITestContext context) {
		String token = (String) context.getAttribute("token");
		Response response = UserApi.get(token);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
