package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Bearings;

public interface BearingsRepository extends CrudRepository<Bearings, Integer>{

	public List<Bearings> findByBrandName(String brandName);
	
	@Query("SELECT DISTINCT brandName FROM Bearings")
	public List<String> findAllBrandNames();
	
}
