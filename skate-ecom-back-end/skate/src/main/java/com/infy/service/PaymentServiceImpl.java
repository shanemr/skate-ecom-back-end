package com.infy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.dto.PaymentDTO;
import com.infy.entity.Payment;
import com.infy.exception.SkateShopException;
import com.infy.repository.PaymentRepository;

public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@Override
	public PaymentDTO findPaymentById(Integer id) throws SkateShopException{
		// TODO Auto-generated method stub
		Payment payment =  paymentRepository.findById(id).orElseThrow(() -> new SkateShopException("Service.No_Payments_Found"));
		PaymentDTO dto = new PaymentDTO(payment.getCard(), payment.getPaymentDate(), payment.getAmount());
		return dto;
	}

}
