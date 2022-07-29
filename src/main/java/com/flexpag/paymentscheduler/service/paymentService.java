package com.flexpag.paymentscheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.paymentscheduler.model.Payment;
import com.flexpag.paymentscheduler.repository.PaymentRepository;

@Service
public class paymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	//Buscar todos os pagamentos
	public List<Payment>findAll(){
		return paymentRepository.findAll();
	}
	
	//Buscar pagamentos por id
	public Optional<Payment>getPaymentById(Long id){
		return paymentRepository.findById(id);
	}
	
		
	//Deletar agendamento por id
	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}
	
	
	
}
