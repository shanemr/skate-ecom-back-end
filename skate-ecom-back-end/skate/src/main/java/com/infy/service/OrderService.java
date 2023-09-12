package com.infy.service;

import java.sql.Date;
import java.util.List;

import com.infy.dto.OrderDTO;
import com.infy.dto.PurchasedItemDTO;


public interface OrderService {
	public Integer purchase(OrderDTO orderDTO);
}
