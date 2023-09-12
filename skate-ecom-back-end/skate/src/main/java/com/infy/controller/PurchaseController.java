package com.infy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Order;

@RestController
@RequestMapping("purchase")
public class PurchaseController {
	
	
	@PostMapping("")
	public ResponseEntity<String> placeOrder(@RequestBody Order order){
		
		
		return new ResponseEntity<String>("Placed", HttpStatus.OK);
	}
	
}
