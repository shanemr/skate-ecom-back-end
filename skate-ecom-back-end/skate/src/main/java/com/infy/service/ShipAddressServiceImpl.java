package com.infy.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.ShipAddressDTO;
import com.infy.entity.ShipAddress;
import com.infy.exception.SkateShopException;
import com.infy.repository.ShipAddressRepository;


@Service
public class ShipAddressServiceImpl implements ShipAddressService{

	
	@Autowired
	private ShipAddressRepository shipAddressRepo;
	
	@Override
	public List<ShipAddressDTO> getShippingAddress(String id) throws SkateShopException{
		// TODO Auto-generated method stub
		List<ShipAddress> shipAddress = shipAddressRepo.getShipAddressByUserId(id);
		if(shipAddress.isEmpty()) {
			throw new SkateShopException("");
		}
		List<ShipAddressDTO> dtos = new ArrayList<ShipAddressDTO>();
		shipAddress.forEach(a ->{
			ShipAddressDTO dto = new ShipAddressDTO();
			dto.setAptStNumber(a.getAptStNumber());
			dto.setPreferredAddress(a.getPreferredAddress());
			dto.setStreetAddress(a.getStreetAddress());
			dto.setZipCode(a.getZipCode());
			dto.setCity(a.getCity());
			dto.setState(a.getState());
			dtos.add(dto);
		});
		
		
		return dtos;
	}

}
