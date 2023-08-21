package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.BearingsDTO;
import com.infy.dto.DeckDTO;
import com.infy.dto.TrucksDTO;
import com.infy.dto.WheelsDTO;
import com.infy.dto.BrandsDTO;
import com.infy.exception.SkateShopException;
import com.infy.service.BearingsService;
import com.infy.service.DeckService;
import com.infy.service.TrucksService;
import com.infy.service.WheelsService;

@RestController()
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class ProductsController {

	@Autowired
	private DeckService deckService;
	
	@Autowired
	private BearingsService bearingsService;
	
	@Autowired
	private TrucksService trucksService;
	
	@Autowired
	private WheelsService wheelsService;
	
	@Autowired
	//private PasswordEncoder passwordEncoder;
	
	
	
	@GetMapping("/allBrands")
	public ResponseEntity<BrandsDTO> getAllBrands() throws SkateShopException{
		List<String> deckNames = deckService.getAllBrandNames();
		List<String> trucksNames = trucksService.getAllBrandNames();
		List<String> wheelsNames = wheelsService.getAllBrandNames();
		List<String> bearingsNames = bearingsService.getAllBrandNames();
		BrandsDTO brandsDTO = new BrandsDTO(deckNames, trucksNames, wheelsNames, bearingsNames);
		return new ResponseEntity<BrandsDTO>(brandsDTO, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/allDecks")
	public ResponseEntity<List<DeckDTO>> getAllDecks() throws SkateShopException{
		List<DeckDTO> deckDTOs = deckService.getAllSkateBoards();
		return new ResponseEntity<List<DeckDTO>>(deckDTOs, HttpStatus.OK);
	}
	
	
	@GetMapping("/allTrucks")
	public ResponseEntity<List<TrucksDTO>> getAllTrucks() throws SkateShopException{
		List<TrucksDTO> truckDTOs = trucksService.getAllTrucks();
		return new ResponseEntity<List<TrucksDTO>>(truckDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/allWheels")
	public ResponseEntity<List<WheelsDTO>> getAllWheels() throws SkateShopException{
		List<WheelsDTO> wheelDTOs = wheelsService.getAllWheels();
		return new ResponseEntity<List<WheelsDTO>>(wheelDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/allBearings")
	public ResponseEntity<List<BearingsDTO>> getAllBearings() throws SkateShopException{
		List<BearingsDTO> bearingsDTOs = bearingsService.getAllBearings();
		return new ResponseEntity<List<BearingsDTO>>(bearingsDTOs, HttpStatus.OK);
	}
	
	
	
}
