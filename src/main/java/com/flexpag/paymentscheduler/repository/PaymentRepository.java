package com.flexpag.paymentscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flexpag.paymentscheduler.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	List<Payment> findAllByStatusContainingIgnoreCase(String status);
	

	

}
