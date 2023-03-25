package com.infy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.infy.dto.DeckDTO;
import com.infy.exception.SkateShopException;
import com.infy.dto.BearingsDTO;
import com.infy.dto.TrucksDTO;
import com.infy.dto.DeckColor;
import com.infy.service.BearingsService;
import com.infy.service.DeckService;
import com.infy.service.TrucksService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SkateApplication implements CommandLineRunner{

	
	@Autowired
	private DeckService skateboardService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BearingsService bearingsService;
	
	@Autowired
	private TrucksService trucksService;
	
	public static void main(String[] args) {
		SpringApplication.run(SkateApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// SkateBoard service method tests
		//addSkateDeck();
		//updateDeckQuantity();
		//getAllSkateBoards();
		//getAllSkateBoardsByBrand();
		//getAllSkateBoardsBySize();
		//getAllSkateBoardsByColor();
		
		// Bearings service method tests
		//addBearings();
		//getAllBearings();
		getAllBrandNames();
		//getBearingsByBrand();
		//getBearingsQuantityInStock();
		//updateBearingsQuantity();
		//purchaseBearings();
		
		// Trucks service methods test
		//getAllTrucks();
		//getTrucksByBrandName();
		//getTrucksInStock();
		//updateTrucksQuantity();
		//purchaseTrucks();

	}
	
	
	public void getAllBrandNames() {
		
			try {
				List<String> names = bearingsService.getAllBrandNames();
				names.forEach(s -> {
					System.out.print("Brand name," + s);
					
				});
			} catch(SkateShopException e) {
				System.out.println(e.getMessage());
			}
			
	}
	
	
	
	public void addSkateDeck() {
		DeckDTO deck = new DeckDTO();
		deck.setBrandName("Element");
		deck.setColor(DeckColor.RED);
		deck.setPrice(59.99);
		deck.setQuantity(5);
		deck.setSize(8.25);
		
		try {
			Integer brandId = skateboardService.addNewSkateBoardBrand(deck, deck.getQuantity());
			System.out.println("SkateBoard added succesfully with brand Id: " + brandId);
		} catch (SkateShopException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	public void updateDeckQuantity() {
		DeckDTO deck = new DeckDTO();
		deck.setBrandId(1);
		deck.setQuantity(5);
		try {
			Integer quantity = skateboardService.updateDeckQuantity(deck, deck.getQuantity());
			System.out.println("Deck quantity updated to: " + quantity);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void getAllSkateBoards() {
		try {
			List<DeckDTO> deckDTOs = skateboardService.getAllSkateBoards();
			deckDTOs.forEach(s -> {
				System.out.print(s.getBrandId() + " ");
				System.out.print(s.getBrandName() + " ");
				System.out.print(s.getSize() + " ");
				System.out.print(s.getColor() + " ");
				System.out.print(s.getPrice() + "\n");
			});
		} catch(SkateShopException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void getAllSkateBoardsByBrand() {
		try {
			List<DeckDTO> deckDTOs = skateboardService.getSkateBoardsByBrand("Baker");
			deckDTOs.forEach(s -> {
				System.out.print(s.getBrandId() + " ");
				System.out.print(s.getBrandName() + " ");
				System.out.print(s.getSize() + " ");
				System.out.print(s.getColor() + " ");
				System.out.print(s.getPrice() + "\n");
			});
		} catch(SkateShopException e) {
			System.out.println(environment.getProperty(e.getMessage()));
			
		}
		
	}
	
	
	public void getAllSkateBoardsBySize() {
		try {
			List<DeckDTO> deckDTOs = skateboardService.getSkateBoardsBySize(8.25);
			deckDTOs.forEach(s -> {
				System.out.print(s.getBrandId() + " ");
				System.out.print(s.getBrandName() + " ");
				System.out.print(s.getSize() + " ");
				System.out.print(s.getColor() + " ");
				System.out.print(s.getPrice() + "\n");
			});
		} catch(SkateShopException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void getAllSkateBoardsByColor() {
		try {
			List<DeckDTO> deckDTOs = skateboardService.getSkateBoardsByColor(DeckColor.RED);
			deckDTOs.forEach(s -> {
				System.out.print(s.getBrandId() + " ");
				System.out.print(s.getBrandName() + " ");
				System.out.print(s.getSize() + " ");
				System.out.print(s.getColor() + " ");
				System.out.print(s.getPrice() + "\n");
			});
		} catch(SkateShopException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void addBearings() {
		BearingsDTO bearings = new BearingsDTO();
		bearings.setBrandName("Indy");
		bearings.setPrice(45.00);
		bearings.setQuantity(10);
		
		try {
			Integer bearingsId = bearingsService.addNewBearings(bearings, bearings.getQuantity());
			System.out.println("Bearings added with brandId: " + bearingsId);
		} catch(Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	public void getAllBearings() {
		try {
			List<BearingsDTO> bearingsDTOs = bearingsService.getAllBearings();
			bearingsDTOs.forEach(b -> {
				System.out.print(b.toString() + "\n");
			});
		} catch(Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
		
	}
	
	public void getBearingsByBrand() {
		try {
			List<BearingsDTO> bearingsDTOs = bearingsService.getByBrandName("Reds");
			bearingsDTOs.forEach(b -> {
				System.out.print(b.toString() + "\n");
			});
		} catch(Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	public void getBearingsQuantityInStock() {
		BearingsDTO bearingsDTO = new BearingsDTO();
		bearingsDTO.setBrandId(1);
		
		try {
			Integer bearingsQuantity = bearingsService.getQuantityInStock(bearingsDTO);
			System.out.println("Amount in stock is: " + bearingsQuantity);
		} catch(Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	public void updateBearingsQuantity() {
		BearingsDTO bearingsDTO = new BearingsDTO();
		bearingsDTO.setBrandId(3);
		
		try {
			Integer bearingsQuantity = bearingsService.updateBearingsQuantity(bearingsDTO, 5);
			System.out.println("Amount in stock is now: " + bearingsQuantity);
		} catch(Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	
	public void purchaseBearings() {
		BearingsDTO bearingsDTO = new BearingsDTO();
		bearingsDTO.setBrandId(1);
		try {
			Integer bearingsQuantity = bearingsService.purchaseBearings(bearingsDTO, 5);
			System.out.println("Bearings purchased! Amount in stock is now: " + bearingsQuantity);
		} catch(Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	public void getAllTrucks() {
		try {
			List<TrucksDTO> trucksDTOs = trucksService.getAllTrucks();
			trucksDTOs.forEach(t -> {
				System.out.println(t.toString());
			});
			
		} catch(SkateShopException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	public void getTrucksByBrandName() {
		try {
			List<TrucksDTO> trucksDTOs = trucksService.getTrucksByBrandName("Tensor");
			trucksDTOs.forEach(t -> {
				System.out.println(t.toString());
			});
			
		} catch(SkateShopException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	
	public void getTrucksInStock() {
		TrucksDTO truckDTO = new TrucksDTO();
		truckDTO.setBrandId(1);
		try {
			Integer amount = trucksService.getQuantityInStock(truckDTO);
			System.out.println("Trucks amount in stock: " + amount);
			
		} catch(SkateShopException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	
	public void updateTrucksQuantity() {
		TrucksDTO truckDTO = new TrucksDTO();
		truckDTO.setBrandId(1);
		try {
			Integer amount = trucksService.updateTrucksQuantity(truckDTO, 5);
			System.out.println("Trucks amount in stock: " + amount);
			
		} catch(SkateShopException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	public void purchaseTrucks() {
		TrucksDTO truckDTO = new TrucksDTO();
		truckDTO.setBrandId(1);
		try {
			Integer amount = trucksService.purchaseTrucks(truckDTO, 5);
			System.out.println("Trucks purchased! Trucks amount in stock: " + amount);
			
		} catch(SkateShopException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	public void addNewTrucks() {
		TrucksDTO truckDTO = new TrucksDTO();
		truckDTO.setBrandName("Venture");
		try {
			Integer amount = trucksService.updateTrucksQuantity(truckDTO, 5);
			System.out.println("Trucks amount in stock: " + amount);
			
		} catch(SkateShopException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	
	
	
	

}
