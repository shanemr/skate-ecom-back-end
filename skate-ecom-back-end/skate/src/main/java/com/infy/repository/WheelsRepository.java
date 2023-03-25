package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infy.dto.WheelsDTO;
import com.infy.entity.Wheels;

public interface WheelsRepository extends CrudRepository<Wheels, Integer>{

	public List<Wheels> findByBrandName(String brandName);
	
	@Query("SELECT DISTINCT brandName FROM Wheels")
	public List<String> findAllBrandNames();
	
	@Query("SELECT w From Wheels w WHERE w.size = :size")
	public List<Wheels> findByWheelSize(Integer size);
}
