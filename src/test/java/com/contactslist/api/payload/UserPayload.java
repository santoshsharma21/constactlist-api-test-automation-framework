/**
 * 
 */
package com.contactslist.api.payload;

import com.contactslist.api.pojos.User;
import com.github.javafaker.Faker;

/**
 * @author Santosh Sharma
 *
 */
public class UserPayload {
	
	static Faker faker = new Faker();
	private static String newFname = faker.name().firstName();
	private static String newLname = faker.name().lastName();
	private static String newEmail = faker.internet().emailAddress();
	private static String newPassword = faker.internet().password();
	
	private static String updatedLname = faker.name().lastName();
	private static String updatedPassword = faker.internet().password();
	
	private static String loginEmail = newEmail;
	private static String loginPassword = updatedPassword;
	
	public static User newUserPayload() {
		return User.builder()
				.firstName(newFname)
				.lastName(newLname)
				.email(newEmail)
				.password(newPassword).build();
	}
	
	public static User userUpdatePayload() {
		return User.builder()
				.lastName(updatedLname)
				.password(updatedPassword).build();
	}
	
	public static User userLoginPayload() {
		return User.builder()
				.email(loginEmail)
				.password(loginPassword).build();
	}

}
