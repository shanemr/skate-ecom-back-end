package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.entity.ShipAddress;

public interface ShipAddressRepository extends JpaRepository<ShipAddress, Integer>{
	@Query("SELECT b from ShipAddress b WHERE b.userProfile.id like :id")
	public List<ShipAddress> getShipAddressByUserId(String id);
}
