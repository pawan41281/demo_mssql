package com.example.demo_mssql.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	@Column(name = "Countryname")
	private String countryname;
}
