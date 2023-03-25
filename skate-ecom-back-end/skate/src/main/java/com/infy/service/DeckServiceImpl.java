package com.infy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.DeckColor;
import com.infy.dto.DeckDTO;
import com.infy.entity.Deck;
import com.infy.exception.SkateShopException;
import com.infy.repository.DeckRepository;

@Service("deckService")
@Transactional
public class DeckServiceImpl implements DeckService{

	@Autowired
	DeckRepository deckRepository;
	
	@Override
	public List<DeckDTO> getAllSkateBoards() throws SkateShopException {
		// TODO Auto-generated method stub
		List<DeckDTO> deckDTOs = ((List<Deck>) deckRepository.findAll())
									.stream().map(skateBoard -> {
										DeckDTO deckDTO = new DeckDTO(
												skateBoard.getBrandId(), skateBoard.getBrandName()
												,skateBoard.getColor(), skateBoard.getSize()
												,skateBoard.getQuantity(), skateBoard.getPrice()
												,skateBoard.getImageUrl());
										return deckDTO;
									}).collect(Collectors.toList());
		if(deckDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_SKATEBOARDS_FOUND");
		}
		
		
		return deckDTOs;
	}

	@Override
	public List<DeckDTO> getSkateBoardsBySize(Double size) throws SkateShopException {
		// TODO Auto-generated method stub
		List<DeckDTO> deckDTOs = deckRepository.findBySize(size)
											.stream().map(skateBoard -> {
												DeckDTO deckDTO = new DeckDTO(
														skateBoard.getBrandId(), skateBoard.getBrandName()
														,skateBoard.getColor(), skateBoard.getSize()
														,skateBoard.getQuantity(), skateBoard.getPrice(),
														skateBoard.getImageUrl());
												return deckDTO;
											}).collect(Collectors.toList());
		
		if(deckDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_SKATEBOARD_SIZE_FOUND");
		}
		return deckDTOs;
	}

	@Override
	public List<DeckDTO> getSkateBoardsByBrand(String brandName) throws SkateShopException {
		// TODO Auto-generated method stub
		List<DeckDTO> deckDTOs = deckRepository.findByBrandName(brandName)
											 .stream().map(skateBoard -> {
												 DeckDTO deckDTO = new DeckDTO(
															skateBoard.getBrandId(), skateBoard.getBrandName()
															,skateBoard.getColor(), skateBoard.getSize()
															,skateBoard.getQuantity(), skateBoard.getPrice(),
															skateBoard.getImageUrl());
													return deckDTO;
												 
											 }).collect(Collectors.toList());
		if(deckDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_SKATEBOARDS_BRAND_FOUND");
		}
		return deckDTOs;
	}

	@Override
	public List<DeckDTO> getSkateBoardsByColor(DeckColor color) throws SkateShopException {
		// TODO Auto-generated method stub
		List<DeckDTO> deckDTOs = deckRepository.findByColor(color)
				 .stream().map(skateBoard -> {
					 DeckDTO deckDTO = new DeckDTO(
								skateBoard.getBrandId(), skateBoard.getBrandName()
								,skateBoard.getColor(), skateBoard.getSize()
								,skateBoard.getQuantity(), skateBoard.getPrice(),
								skateBoard.getImageUrl());
						return deckDTO;
					 
				 }).collect(Collectors.toList());
		if(deckDTOs.isEmpty()) {
			throw new SkateShopException("Service.NO_SKATEBOARDS_COLOR_FOUND");
		}
		return deckDTOs;
	}

	@Override
	public Integer getQuantityInStock(DeckDTO deckDTO) throws SkateShopException {
		// TODO Auto-generated method stub
		Deck deck = deckRepository.findById(deckDTO.getBrandId())
				.orElseThrow(() -> new SkateShopException("Service.NO_SKATEBOARDS_FOUND"));
		return deck.getQuantity();
	}

	@Override
	public Integer addNewSkateBoardBrand(DeckDTO deckDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
//		if(skateBoardRepository.findById(skateBoardDTO.getBrandId()).isPresent()) {
//			throw new SkateShopException("Service.SKATEBOARD_ALREADY_EXISTS");
//		}
		Deck deck = Deck.convertToEntity(deckDTO);
		deck.setQuantity(quantity);
		Integer brandId = 0;
		
		try {
			deckRepository.save(deck).getBrandId();
		} catch(Exception e) {
			throw new SkateShopException("Service.SKATEBOARD_ALREADY_EXISTS");
		}
		return brandId;
	}

	@Override
	public Integer updateDeckQuantity(DeckDTO deckDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
		Deck deck = deckRepository.findById(deckDTO.getBrandId())
								.orElseThrow(() -> new SkateShopException("Service.NO_SKATEBOARDS_FOUND"));
		
		deck.setQuantity(deck.getQuantity() + quantity);
								
		return deck.getQuantity();
	}

	@Override
	public void purchaseSkateBoard(DeckDTO deckDTO, Integer quantity) throws SkateShopException {
		// TODO Auto-generated method stub
		Deck deck = deckRepository.findById(deckDTO.getBrandId())
									.orElseThrow(() -> new SkateShopException("Service.NO_SKATEBOARDS_FOUND"));
		if(deck.getQuantity() <= 0) {
			throw new SkateShopException("Service.SKATEBOARD_SOLD_OUT");
		} else if(deck.getQuantity() < quantity) {
			throw new SkateShopException("Service.QUANTITY_INVALID");
		}
		
		deck.setQuantity(deck.getQuantity() - quantity);
		
	}

	@Override
	public List<String> getAllBrandNames() throws SkateShopException {
		// TODO Auto-generated method stub
		List<String> brandNames = deckRepository.findAllBrandNames();
		return brandNames;
	}
	
	

	
	
	
}
