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
import com.contactslist.api.utilities.TestUtilities;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class UserApiTests {

	// get request payload
	private User userPayload;
	private User updatePayload;
	private User loginPayload;

	@Test(priority = 0)
	public void addNewUser(ITestContext context) {
		// get new user payload
		userPayload = UserPayload.newUserPayload();
		// post request
		Response response = UserApi.post(true, false, userPayload);
		// get and store token
		String bearertoken = TestUtilities.getStringFromJsonObj(response, "token");
		context.setAttribute("token", bearertoken);
		// validate response
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(TestUtilities.getStringFromInnerJsonObj(response, "user", "firstName"),
				userPayload.getFirstName());
		Assert.assertEquals(TestUtilities.getStringFromInnerJsonObj(response, "user", "lastName"),
				userPayload.getLastName());
		Assert.assertEquals(TestUtilities.getStringFromInnerJsonObj(response, "user", "email"), userPayload.getEmail());
	}

	@Test(priority = 1)
	public void getUserProfile(ITestContext context) {
		// get token
		String token = (String) context.getAttribute("token");
		// get request
		Response response = UserApi.get(token);
		// validate response
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(TestUtilities.getStringFromJsonObj(response, "firstName"), userPayload.getFirstName());
		Assert.assertEquals(TestUtilities.getStringFromJsonObj(response, "lastName"), userPayload.getLastName());
		Assert.assertEquals(TestUtilities.getStringFromJsonObj(response, "email"), userPayload.getEmail());
	}

	@Test(priority = 2)
	public void updateUser(ITestContext context) {
		// get token
		String token = (String) context.getAttribute("token");
		// get payload
		updatePayload = UserPayload.userUpdatePayload();
		// patch request
		Response response = UserApi.patch(token, updatePayload);
		// validate response
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(TestUtilities.getStringFromJsonObj(response, "firstName"), updatePayload.getFirstName());
		Assert.assertEquals(TestUtilities.getStringFromJsonObj(response, "lastName"), updatePayload.getLastName());
	}
	
	@Test(priority = 4)
	public void userLogin() {
		// get payload
		loginPayload = UserPayload.userLoginPayload();
		// post request
		Response response = UserApi.post(false, true, loginPayload);
		// validate response
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(TestUtilities.getStringFromInnerJsonObj(response, "user", "email"), loginPayload.getEmail());
	}
	
	@Test(priority = 3)
	public void userLogout(ITestContext context) {
		// get token
		String token = (String) context.getAttribute("token");
		// patch request
		Response response = UserApi.post(token);
		// validate response
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 5)
	public void deleteUser(ITestContext context) {
		// get token
		String token = (String) context.getAttribute("token");
		// delete request
		Response response = UserApi.delete(token);
		// validate response
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
