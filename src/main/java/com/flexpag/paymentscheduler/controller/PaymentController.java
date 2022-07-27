package com.flexpag.paymentscheduler.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("status/{status}")
	public ResponseEntity<List<Payment>> getByStatus(@PathVariable String status){
		return ResponseEntity.ok(paymentRepository.findAllByStatusContainingIgnoreCase(status));
	}
		
	@PostMapping
	public ResponseEntity<Payment> post(@Validated @RequestBody Payment payment){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(paymentRepository.save(payment));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment payment){
				
	if(!paymentRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	
	payment.setId(id);
	payment = paymentRepository.save(payment);
	return ResponseEntity.ok(payment);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
	if(!paymentRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	
	paymentRepository.deleteById(id);
	return ResponseEntity.noContent().build();
	
	}
}	

