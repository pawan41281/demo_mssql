package com.example.demo_mssql.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_mssql.service.CountryServiceImpl;
import com.example.demo_mssql.vo.CountryVo;
import com.example.demo_mssql.wrapper.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/Countries")
@Tag(description = "Country API", name = "Country API")
@SecurityRequirement(name = "Bearer Authentication")
public class CountryController {

	private final CountryServiceImpl service;

	public CountryController(CountryServiceImpl service) {
		this.service = service;
	}

	@GetMapping("")
	@Operation(summary = "Get all countries", description = "Fetches all countries from database")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<ApiResponse<List<CountryVo>>> getCountrys() {
		List<CountryVo> list = service.findAll();
		Map<String, Integer> map = new HashMap<>();
		map.put("Record Count", list.size());
		ApiResponse<List<CountryVo>> apiResponse = new ApiResponse<>("success", "Record retrieved successfully", list, map);
		return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get country by id", 
				description = "Fetches a country using their ID")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ApiResponse<CountryVo>> find(
			@Parameter(description = "ID of country to be retrieved", required = true)
			@PathVariable Long id) {
		CountryVo countryVo = service.find(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("Record Count", countryVo!=null?1:0);
		ApiResponse<CountryVo> apiResponse = new ApiResponse<>("success", "Record retrieved successfully", countryVo, map);
		return ResponseEntity.ok(apiResponse);
	}

	@PostMapping("")
	@Operation(summary = "Save a country", description = "Save a new country in the database")
	public CountryVo postMethodName(@RequestBody CountryVo CountryVo) {
		return service.save(CountryVo);
	}

}
