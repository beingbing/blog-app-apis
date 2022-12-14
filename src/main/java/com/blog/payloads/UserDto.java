package com.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int userId;
	
	@NotEmpty
	@Size(min = 4, message = "username must be min of 4 characters !!")
	private String name;
	
	@Email(message = "email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 50, message = "password length should be between 3 and 50 characters inclusive")
	private String password;
	
	@NotEmpty
	private String about;

}
