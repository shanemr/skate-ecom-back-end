package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.entity.BillAddress;

public interface BillingAddressRepository extends JpaRepository<BillAddress, Integer>{
	@Query("SELECT b from BillAddress b WHERE b.id like :id")
	public BillAddress findBillAddressByUserId(String id);
}
