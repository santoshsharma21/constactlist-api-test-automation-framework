/**
 * 
 */
package com.contactslist.api.restutilities;

import static io.restassured.RestAssured.given;

import com.contactslist.api.extentreport.ReportLogger;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

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
		
		logRequestDetails(reqSpec, "POST", endpoint, true);
		logResponseDetails(response, true);
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
		
		logRequestDetails(reqSpec, "POST", endpoint, false);
		logResponseDetails(response, false);
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
		
		logRequestDetails(reqSpec, "GET", endpoint, false);
		logResponseDetails(response, true);
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
		
		logRequestDetails(reqSpec, "PATCH", endpoint, true);
		logResponseDetails(response, true);
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
		
		logRequestDetails(reqSpec, "DELETE", endpoint, false);
		logResponseDetails(response, false);
		return response;
	}
	
	
	public static void logRequestDetails(RequestSpecification reqSpec, String method, String endpoint, boolean payload) {
		QueryableRequestSpecification reqQuery = SpecificationQuerier.query(reqSpec);
		
		if(payload) {
			ReportLogger.logText("Request Details");
			ReportLogger.logText("URI - " + reqQuery.getURI() + endpoint);
			ReportLogger.logText("HTTP Method - " + method);
			ReportLogger.logText("Request Body");
			ReportLogger.logJson(reqQuery.getBody());
		} else {
			ReportLogger.logText("Request Details");
			ReportLogger.logText("URI - " + reqQuery.getURI() + endpoint);
			ReportLogger.logText("HTTP Method - " + method);
		}
	}
	
	public static void logResponseDetails(Response response, boolean payload) {
		
		if(payload) {
			ReportLogger.logText("Status Code - " + response.getStatusCode());
			ReportLogger.logText("Response Body");
			ReportLogger.logJson(response.asPrettyString());
		} else {
			ReportLogger.logText("Status Code - " + response.getStatusCode());
			ReportLogger.logText("No Response Body");
		}
	}
}
