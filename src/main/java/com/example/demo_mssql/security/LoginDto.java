package com.example.demo_mssql.security;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	
	@NotNull(message = "Invalid UsernameOrEmail: UsernameOrEmail is NULL")
	private String usernameOrEmail;
	
	@NotNull(message = "Invalid Password: Password is NULL")
	private String password;
}