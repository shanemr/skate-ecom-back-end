package com.infy.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.TrucksDTO;
import com.infy.entity.Trucks;
import com.infy.exception.SkateShopException;
import com.infy.repository.TrucksRepository;

@Service("trucksService")
@Transactional
public class TrucksServiceImpl implements TrucksService{

	
	@Autowired
	TrucksRepository trucksRepository;
	
	@Override
	public List<TrucksDTO> getAllTrucks() throws SkateShopException {
		// TODO Auto-generated method stub
		List<TrucksDTO> trucksDTOs = ((Collection<Trucks>) trucksRepository.findAll())
										.stream().map(trucks ->{
											TrucksDTO trucksDTO = TrucksDTO.convertToDTO(trucks);
											return trucksDTO;
										}).collect(Collectors.toList());
		if(trucksDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_TRUCKS_FOUND");
		}
		return trucksDTOs;
	}

	@Override
	public List<TrucksDTO> getTrucksByBrandName(String brandName) throws SkateShopException {
		// TODO Auto-generated method stub
		List<TrucksDTO> trucksDTO = trucksRepository.findByBrandName(brandName).stream().map(trucks ->{
									TrucksDTO truckDTO = TrucksDTO.convertToDTO(trucks);
									return truckDTO;
									}).collect(Collectors.toList());
		if(trucksDTO.isEmpty()) {
			throw new SkateShopException("Service.NO_TRUCKS_FOUND");
		}					 
		
		return trucksDTO;
	}

	@Override
	public Integer getQuantityInStock(TrucksDTO trucksDTO) throws SkateShopException {
		// TODO Auto-generated method stub
		Trucks trucks = trucksRepository.findById(trucksDTO.getBrandId())
										.orElseThrow(() -> new SkateShopException("Service.NO_TRUCKS_FOUND"));
		return trucks.getQuantity();
	}

	@Override
	public Integer updateTrucksQuantity(TrucksDTO trucksDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
		Trucks trucks = trucksRepository.findById(trucksDTO.getBrandId())
				.orElseThrow(() -> new SkateShopException("Service.NO_TRUCKS_FOUND"));
		trucks.setQuantity(trucks.getQuantity() + quantity);
		return trucks.getQuantity();
	}

	@Override
	public Integer addNewTrucksType(TrucksDTO trucksDTO) throws SkateShopException {
		// TODO Auto-generated method stub
//		if(trucksRepository.findByBrandName(trucksDTO.getBrandName()) != null) {
//			throw new SkateShopException("Service.TRUCKS_ALREADY_EXISTS");
//		}
		Trucks trucks = Trucks.convertyToEntity(trucksDTO);
		
		return trucksRepository.save(trucks).getBrandId();
	}

	@Override
	public Integer purchaseTrucks(TrucksDTO trucksDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
		Trucks trucks = trucksRepository.findById(trucksDTO.getBrandId())
						.orElseThrow(() -> new SkateShopException("Service.NO_TRUCKS_FOUND"));
		if(trucks.getQuantity() <= 0) {
			throw new SkateShopException("Service.TRUCKS_OUT_OF_STOCK");
		} else if(trucks.getQuantity() < quantity) {
			throw new SkateShopException("Service.QUANTITY_INVALID");
		}
		
		trucks.setQuantity(trucks.getQuantity() - quantity);
		return trucks.getQuantity();
		
	}

	@Override
	public List<String> getAllBrandNames() throws SkateShopException {
		// TODO Auto-generated method stub
		List<String> brandNames = trucksRepository.findAllBrandNames();
		return brandNames;
	}

	

}
