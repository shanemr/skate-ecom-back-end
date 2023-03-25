package com.infy.service;

import java.util.List;

import com.infy.dto.TrucksDTO;
import com.infy.entity.Trucks;
import com.infy.exception.SkateShopException;

public interface TrucksService {
	public List<TrucksDTO> getAllTrucks() throws SkateShopException;
	
	public List<TrucksDTO> getTrucksByBrandName(String brandName) throws SkateShopException;
	
	public Integer getQuantityInStock(TrucksDTO trucks) throws SkateShopException;
	
	public Integer updateTrucksQuantity(TrucksDTO trucks, Integer quantity) throws SkateShopException;
	
	public Integer addNewTrucksType(TrucksDTO trucks) throws SkateShopException;
	
	public Integer purchaseTrucks(TrucksDTO trucks, Integer quantity) throws SkateShopException;
	
	public List<String> getAllBrandNames() throws SkateShopException;
	
}
