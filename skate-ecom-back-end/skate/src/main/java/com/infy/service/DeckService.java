package com.infy.service;



import java.util.List;

import com.infy.dto.DeckColor;
import com.infy.dto.DeckDTO;
import com.infy.exception.SkateShopException;

public interface DeckService {

	public List<DeckDTO> getAllSkateBoards() throws SkateShopException;
	
	public List<DeckDTO> getSkateBoardsBySize(Double size) throws SkateShopException;
	
	public List<DeckDTO> getSkateBoardsByBrand(String brandName) throws SkateShopException;
	
	public List<DeckDTO> getSkateBoardsByColor(DeckColor color) throws SkateShopException;
	
	public Integer getQuantityInStock(DeckDTO skateboardDTO) throws SkateShopException;
	
	public Integer updateDeckQuantity(DeckDTO deckDTO, Integer quantity) throws SkateShopException;
	
	public Integer addNewSkateBoardBrand(DeckDTO deckDTO, Integer quantity) throws SkateShopException;
	
	public void purchaseSkateBoard(DeckDTO deckDTO, Integer quantity) throws SkateShopException;
	
	public List<String> getAllBrandNames() throws SkateShopException;
}
