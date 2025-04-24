package com.example.demo_mssql.security;

public interface AuthService {
	String login(LoginDto loginDto);
}