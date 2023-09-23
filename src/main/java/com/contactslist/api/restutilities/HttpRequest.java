/**
 * 
 */
package com.contactslist.api.restutilities;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author Santosh Sharma
 *
 */
public class HttpRequest {
	
	// POST Request
	public static Response post(String endpoint, Object payload) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuild(payload);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuild(true);
		
		Response response = given()
			.spec(reqSpec)
		
		.when()
			.post(endpoint)
		
		.then()
			.spec(resSpec)
			.log().all().extract().response();
			
		return response;
	}
	
	public static Response post(String endpoint, String token) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuild(token);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuild(false);
		
		Response response = given()
			.spec(reqSpec)
		
		.when()
			.post(endpoint)
		
		.then()
			.spec(resSpec)
			.log().all().extract().response();
			
		return response;
	}
	
	// GET Request
	public static Response get(String endpoint, String token) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuild(token);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuild(true);
		
		Response response = given()
			.spec(reqSpec)
		
			.when()
				.get(endpoint)
			
			.then()
				.spec(resSpec)
				.log().all().extract().response();
		
		return response;
	}
	
	// PATCH Request
	public static Response patch(String endpoint, String token, Object payload) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuild(payload, token);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuild(true);
		
		Response response = given()
			.spec(reqSpec)
		
		.when()
			.patch(endpoint)
		
		.then()
			.spec(resSpec)
			.log().all().extract().response();
		
		return response;
	}
	
	// DELETE Request
	public static Response delete(String endpoint, String token) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuild(token);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuild(false);
			
		Response response = given()
			.spec(reqSpec)
			
		.when()
			.delete(endpoint)
			
		.then()
			.spec(resSpec)
			.log().all().extract().response();
			
		return response;
	}

}
