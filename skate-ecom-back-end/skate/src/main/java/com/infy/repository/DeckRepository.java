package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.dto.DeckColor;
import com.infy.entity.Deck;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Integer>{

	public List<Deck> findByBrandName(String brandName);
	
	public List<Deck> findBySize(Double size);
	
	public List<Deck> findByColor(DeckColor color);
	
	@Query("SELECT DISTINCT brandName FROM Deck")
	public List<String> findAllBrandNames();
	
}
