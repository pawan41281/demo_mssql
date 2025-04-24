package com.example.demo_mssql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_mssql.vo.CountryVo;

@Repository
public interface CountryRepo extends JpaRepository<CountryVo, Long> {

}
