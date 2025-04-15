package com.example.demo_mssql.security;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

	private String username;
	private String email;
	private String password;
	private Set<String> role;

	public SignupRequest(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
