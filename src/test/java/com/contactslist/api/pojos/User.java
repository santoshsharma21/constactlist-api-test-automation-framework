/**
 * 
 */
package com.contactslist.api.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

/**
 * @author Santosh Sharma
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@Builder
public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}