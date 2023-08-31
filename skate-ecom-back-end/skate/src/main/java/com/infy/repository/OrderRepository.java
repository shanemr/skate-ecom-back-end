package com.infy.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	
}
