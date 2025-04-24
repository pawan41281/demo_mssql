package com.example.demo_mssql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo_mssql.repo.CountryRepo;
import com.example.demo_mssql.vo.CountryVo;

@Service
public class CountryServiceImpl implements CountryService{

	private final CountryRepo CountryRepo;

	public CountryServiceImpl(CountryRepo CountryRepo) {
		this.CountryRepo = CountryRepo;
	}
	
	@Override
	public List<CountryVo> findAll(){
		return CountryRepo.findAll();
	}
	
	@Override
	public CountryVo find(Long id){
		Optional<CountryVo> countryVo = CountryRepo.findById(id);
		return countryVo.isPresent()?countryVo.get():null;
	}
	
	@Override
	public CountryVo save(CountryVo CountryVo) {
		return CountryRepo.save(CountryVo);
	}
}
