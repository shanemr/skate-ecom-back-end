package com.infy.dto;

import java.util.List;

public class BrandsDTO {
	private List<String> deckBrandNames;
	private List<String> trucksBrandNames;
	private List<String> wheelsBrandNames;
	private List<String> bearingsBrandNames;
	
	
	public BrandsDTO(List<String> deckBrandNames, List<String> trucksBrandNames, List<String> wheelsBrandNames,
			List<String> bearingsBrandNames) {
		super();
		this.deckBrandNames = deckBrandNames;
		this.trucksBrandNames = trucksBrandNames;
		this.wheelsBrandNames = wheelsBrandNames;
		this.bearingsBrandNames = bearingsBrandNames;
	}
	public List<String> getDeckBrandNames() {
		return deckBrandNames;
	}
	public void setDeckBrandNames(List<String> deckBrandNames) {
		this.deckBrandNames = deckBrandNames;
	}
	public List<String> getTrucksBrandNames() {
		return trucksBrandNames;
	}
	public void setTrucksBrandNames(List<String> trucksBrandNames) {
		this.trucksBrandNames = trucksBrandNames;
	}
	public List<String> getWheelsBrandNames() {
		return wheelsBrandNames;
	}
	public void setWheelsBrandNames(List<String> wheelsBrandNames) {
		this.wheelsBrandNames = wheelsBrandNames;
	}
	public List<String> getBearingsBrandNames() {
		return bearingsBrandNames;
	}
	public void setBearingsBrandNames(List<String> bearingsBrandNames) {
		this.bearingsBrandNames = bearingsBrandNames;
	}
	
	
}
