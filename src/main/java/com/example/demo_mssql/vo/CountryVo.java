package com.example.demo_mssql.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Countries")
public class CountryVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryid;
	
	@NotNull(message = "Invalid Country Name: Country name is NULL")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Please enter only string")
	@Column(name = "Countryname", nullable = false, unique = true)
	private String countryname;
}
