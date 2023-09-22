/**
 * 
 */
package com.contactslist.api.routes;

/**
 * @author Santosh Sharma
 *
 */
public class Endpoints {
	
	// User Api Endpoint
	public static String BASE_URL = "https://thinking-tester-contact-list.herokuapp.com";
	public static String ADD_USER = "/users";
	public static String USER_PROFILE = "/users/me";
	public static String UPDATE_USER = "/users/me";
	public static String LOGOUT_USER = "/users/logout";
	public static String LOGIN_USER = "/users/login";
	public static String DELETE_USER = "/users/me";
	
	// Contacts Api endpoint
	public static String ADD_CONTACT = "/contacts";
	public static String GET_CONTACT_LIST = "/contacts";
	public static String GET_CONTACT = "/contacts/";
	public static String UPDATE_CONTACT = "/contacts/";
	public static String PARTIAL_UPDATE_CONTACT = "/contacts/";
	public static String DELETE_CONTACT = "/contacts/";

}
