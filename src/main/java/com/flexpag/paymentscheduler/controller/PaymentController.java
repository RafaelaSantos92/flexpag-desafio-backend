package com.flexpag.paymentscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.model.Payment;
import com.flexpag.paymentscheduler.repository.PaymentRepository;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@GetMapping
	public List<Payment> listaPayment() {
		return paymentRepository.findAll();
	}
	
	@PostMapping
	public Payment add(@RequestBody Payment payment) {
		return paymentRepository.save(payment);
	}
	
	
	
}
