package com.example.demo_mssql.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsernameOrEmail(String username, String email);

	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);
}
