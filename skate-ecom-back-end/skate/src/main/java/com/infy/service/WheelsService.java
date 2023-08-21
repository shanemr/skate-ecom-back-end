package com.infy.service;


import java.util.List;

import com.infy.dto.WheelsDTO;
import com.infy.entity.Wheels;
import com.infy.exception.SkateShopException;


public interface WheelsService {
	
	public List<WheelsDTO> getAllWheels() throws SkateShopException;
	
	public List<WheelsDTO> getWheelsByBrandName(String brandName) throws SkateShopException;
	
	public List<WheelsDTO> getWheelsBySize(Integer size) throws SkateShopException;
	
	public Integer getQuantityInStock(WheelsDTO wheelsDTO) throws SkateShopException;
	
	public Integer addWheels(WheelsDTO wheelsDTO, Integer quantity) throws SkateShopException;
	
	public String addNewWheels(WheelsDTO wheelsDTO) throws SkateShopException;
	
	public Integer purchaseWheels(WheelsDTO wheelsDTO, Integer quantity) throws SkateShopException;
	
	public List<String> getAllBrandNames() throws SkateShopException;
}
