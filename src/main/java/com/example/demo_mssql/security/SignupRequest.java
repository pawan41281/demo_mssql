package com.example.demo_mssql.security;

import java.util.Set;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

	@NotNull(message = "Invalid Name: Name is NULL")
	private String name;
	
	@NotNull(message = "Invalid Userame: Userame is NULL")
	private String username;
	
	@NotNull(message = "Invalid Email: Email is NULL")
	private String email;
	
	@NotNull(message = "Invalid Password: Password is NULL")
	private String password;
	
	private Set<String> role;

	public SignupRequest(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public SignupRequest(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

}