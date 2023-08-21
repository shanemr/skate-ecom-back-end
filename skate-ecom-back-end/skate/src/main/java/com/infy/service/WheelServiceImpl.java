package com.infy.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.WheelsDTO;
import com.infy.entity.Wheels;
import com.infy.exception.SkateShopException;
import com.infy.repository.WheelsRepository;

@Service("wheelsService")
@Transactional
public class WheelServiceImpl implements WheelsService{

	@Autowired
	WheelsRepository wheelsRepository;
	
	@Override
	public List<WheelsDTO> getAllWheels() throws SkateShopException {
		// TODO Auto-generated method stub
		List<WheelsDTO> wheelsDTOs = ((Collection<Wheels>) wheelsRepository.findAll())
									.stream().map(wheels -> {
										WheelsDTO wheelsDTO = WheelsDTO.convertToDTO(wheels);
										return wheelsDTO;
									}).collect(Collectors.toList());
		if(wheelsDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_WHEELS_FOUND");
		}
		return wheelsDTOs;
	}

	@Override
	public List<WheelsDTO> getWheelsByBrandName(String brandName) throws SkateShopException {
		// TODO Auto-generated method stub
		List<WheelsDTO> wheelsDTOs = wheelsRepository.findByBrandName(brandName)
									.stream().map(wheels -> {
									WheelsDTO wheelsDTO = WheelsDTO.convertToDTO(wheels);
									return wheelsDTO;
									}).collect(Collectors.toList());
		if(wheelsDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_WHEELS_FOUND");
		}
		return wheelsDTOs;
	}

	@Override
	public List<WheelsDTO> getWheelsBySize(Integer size) throws SkateShopException {
		// TODO Auto-generated method stub
		List<WheelsDTO> wheelsDTOs = wheelsRepository.findByWheelSize(size)
									.stream().map(wheels -> {
										WheelsDTO wheelsDTO = WheelsDTO.convertToDTO(wheels);
										return wheelsDTO;
									}).collect(Collectors.toList());
		if(wheelsDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_WHEELS_FOUND");
		}
		return wheelsDTOs;
	}

	@Override
	public Integer getQuantityInStock(WheelsDTO wheelsDTO) throws SkateShopException {
		// TODO Auto-generated method stub
		Wheels wheels = wheelsRepository.findById(wheelsDTO.getBrandId())
										.orElseThrow(() -> new SkateShopException("Service.NO_WHEELS_FOUND"));
		return wheels.getQuantity();
	}

	
	@Override
	public Integer addWheels(WheelsDTO wheelsDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
		Wheels wheels = wheelsRepository.findById(wheelsDTO.getBrandId())
				.orElseThrow(() -> new SkateShopException("Service.NO_WHEELS_FOUND"));
		wheels.setQuantity(wheels.getQuantity() + quantity);
		return wheels.getQuantity();
	}
	

	@Override
	public String addNewWheels(WheelsDTO wheelsDTO) throws SkateShopException {
		// TODO Auto-generated method stub
		if(wheelsRepository.existsById(wheelsDTO.getBrandId())) {
			throw new SkateShopException("Service.WHEELS_BRAND_ALREADY_EXISTS");
		}
		
		Wheels wheels = Wheels.convertToEntity(wheelsDTO);
		
		return wheelsRepository.save(wheels).getBrandId();
	}

	@Override
	public Integer purchaseWheels(WheelsDTO wheelsDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
		Wheels wheels = wheelsRepository.findById(wheelsDTO.getBrandId())
				.orElseThrow(() -> new SkateShopException("Service.NO_WHEELS_FOUND"));
		if(wheels.getQuantity() <=0) {
			throw new SkateShopException("Service.WHEELS_SOLD_OUT");
		}
		if(wheels.getQuantity() < quantity) {
			throw new SkateShopException("Service.QUANTITY_INVALID");
		}
		
		wheels.setQuantity(wheels.getQuantity() - quantity);
		return wheels.getQuantity();
	}

	@Override
	public List<String> getAllBrandNames() throws SkateShopException {
		// TODO Auto-generated method stub
		List<String> brandNames = wheelsRepository.findAllBrandNames();
		return brandNames;
	}

	

}
