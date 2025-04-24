package com.example.demo_mssql.security;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotNull(message = "Invalid Name: Name is NULL")
	//@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Please enter only string")
	private String name;
	
	@Column(nullable = false, unique = true)
	@NotNull(message = "Invalid Username: Username is NULL")
	//@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Please enter only string")
	private String username;
	
	@Column(nullable = false, unique = true)
	@NotNull(message = "Invalid Email: Eamil is NULL")
	//@Email(message = "Invalid email")
	private String email;
	
	@Column(nullable = false)
	@NotNull(message = "Invalid Password: Password is NULL")
	//@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Please enter only string")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;

	public User(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}