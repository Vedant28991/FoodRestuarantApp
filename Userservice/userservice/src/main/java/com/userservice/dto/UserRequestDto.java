package com.userservice.dto;

import lombok.Data;

@Data
public class UserRequestDto {
	private String usernameOrEmail;
	private String password;
}
