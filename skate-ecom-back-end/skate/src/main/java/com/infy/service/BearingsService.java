package com.infy.service;


import java.util.List;

import com.infy.dto.BearingsDTO;
import com.infy.entity.Bearings;
import com.infy.exception.SkateShopException;


public interface BearingsService {
		
	public List<BearingsDTO> getAllBearings() throws SkateShopException;
	
	public List<BearingsDTO> getByBrandName(String brandName) throws SkateShopException;
	
	public Integer getQuantityInStock(BearingsDTO bearings) throws SkateShopException;
	
	public Integer updateBearingsQuantity(BearingsDTO bearings, Integer quantity) throws SkateShopException;
	
	public Integer addNewBearings(BearingsDTO bearings, Integer quantity) throws SkateShopException;
	
	public Integer purchaseBearings(BearingsDTO bearings, Integer quantity) throws SkateShopException;
	
	public List<String> getAllBrandNames() throws SkateShopException;
}
