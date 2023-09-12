package com.infy.service;

import java.util.List;

import com.infy.dto.PaymentDTO;
import com.infy.entity.Payment;
import com.infy.exception.SkateShopException;

public interface PaymentService {
	public PaymentDTO findPaymentById(Integer id) throws SkateShopException;
	
}
