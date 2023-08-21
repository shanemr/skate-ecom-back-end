package com.infy.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.BearingsDTO;
import com.infy.entity.Bearings;
import com.infy.exception.SkateShopException;
import com.infy.repository.BearingsRepository;


@Service("bearingsService")
@Transactional
public class BearingsServiceImpl implements BearingsService{
	
	@Autowired
	BearingsRepository bearingsRepository;
	
	@Override
	public List<BearingsDTO> getAllBearings() throws SkateShopException {
		// TODO Auto-generated method stub
		List<BearingsDTO> bearingsDTOs = ((Collection<Bearings>) bearingsRepository.findAll())
										  .stream().map(bearings ->{
											  BearingsDTO bearingsDTO = BearingsDTO.convertToDTO(bearings);
											  return bearingsDTO;
										  }).collect(Collectors.toList());
		if(bearingsDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_BEARINGS_FOUND");
		}				
		
		return bearingsDTOs;
	}

	@Override
	public List<BearingsDTO> getByBrandName(String brandName) throws SkateShopException {
		// TODO Auto-generated method stub
		List<BearingsDTO> bearingsDTOs = bearingsRepository.findByBrandName(brandName)
				  .stream().map(bearings ->{
					  BearingsDTO bearingsDTO = BearingsDTO.convertToDTO(bearings);
					  return bearingsDTO;
				  }).collect(Collectors.toList());
		
		if(bearingsDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_BEARINGS_FOUND");
		}
		
		return bearingsDTOs;
	}

	@Override
	public Integer getQuantityInStock(BearingsDTO bearingsDTO) throws SkateShopException{
		// TODO Auto-generated method stub
		Bearings bearings = bearingsRepository.findById(bearingsDTO.getBrandId())
								  .orElseThrow(() -> new SkateShopException("Service.NO_BEARINGS_FOUND"));
		return bearings.getQuantity();
	}

	@Override
	public Integer updateBearingsQuantity(BearingsDTO bearingsDTO, Integer quantity) throws SkateShopException{
		// TODO Auto-generated method stub
		Bearings bearings = bearingsRepository.findById(bearingsDTO.getBrandId())
							.orElseThrow(() -> new SkateShopException("Service.NO_BEARINGS_FOUND"));
		bearings.setQuantity(bearings.getQuantity() + quantity);
		
		return bearings.getQuantity();
	}

	@Override
	public String addNewBearings(BearingsDTO bearingsDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
//		if(bearingsRepository.findById(bearingsDTO.getBrandId()).isPresent()) {
//			throw new SkateShopException("Service.BEARINGS_BRAND_ALREADY_EXISTS");
//		}
		Bearings bearings = Bearings.convertToEntity(bearingsDTO);
		bearings.setBrandId(this.generateId(bearingsDTO));
		
		return bearingsRepository.save(bearings).getBrandId();
	}

	@Override
	public Integer purchaseBearings(BearingsDTO bearingsDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
		Bearings bearings = bearingsRepository.findById(bearingsDTO.getBrandId())
				.orElseThrow(() -> new SkateShopException("Service.NO_BEARINGS_FOUND"));
		if(bearings.getQuantity() <= 0) {
			throw new SkateShopException("Service.BEARINGS_SOLD_OUT");
		}
		if(bearings.getQuantity() < quantity) {
			throw new SkateShopException("Service.QUANTITY_INVALID");
		}
		
		bearings.setQuantity(bearings.getQuantity() - quantity);
		
		return bearings.getQuantity();
	}

	@Override
	public List<String> getAllBrandNames() throws SkateShopException {
		// TODO Auto-generated method stub
		List<String> brandNames = bearingsRepository.findAllBrandNames();
		return brandNames;
	}

	@Override
	public String generateId(BearingsDTO bearingsDTO) throws SkateShopException {
		// TODO Auto-generated method stub
		
		String id = getAllBrandNames().size() + "-" + bearingsDTO.getBrandName() + "-" + bearingsDTO.getBearingsType();
		return id;
	}

	

}
