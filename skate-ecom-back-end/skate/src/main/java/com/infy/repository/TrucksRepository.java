package com.infy.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infy.dto.TrucksDTO;
import com.infy.entity.Trucks;

public interface TrucksRepository extends CrudRepository<Trucks, String> {

	public List<Trucks> findByBrandName(String brandName);
	
	@Query("SELECT DISTINCT brandName FROM Trucks")
	public List<String> findAllBrandNames();
	
}
