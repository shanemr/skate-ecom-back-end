package com.infy.service;
import java.util.List;

import com.infy.dto.ShipAddressDTO;
import com.infy.exception.SkateShopException;

public interface ShipAddressService {
	public List<ShipAddressDTO> getShippingAddress(String id) throws SkateShopException;
}
