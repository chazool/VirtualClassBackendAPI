package com.virtualClass.App.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.Payment;
import com.virtualClass.App.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private StudentClassService studentClassService;

	public Payment saveOrUpdatePayment(Payment payment) throws Exception {

		payment.setMessageStatus(false);

		if (payment.getMonth() < 1 || payment.getMonth() > 12) {
			payment.setMessage("Invalid Month");
		} else if (payment.getYear() < 2020) {
			payment.setMessage("Invalid Year");
		} else if (studentClassService.getStudentClass(payment.getStudentclassid()).getStudentclassid() != payment
				.getStudentclassid()) {
			payment.setMessage("Invalid Student Class ID");
		} else {
			payment = paymentRepository.save(payment);
			payment.setMessageStatus(true);
		}

		return payment;
	}


	public Payment getPayment(int paymentId) throws Exception {

		Payment payment = paymentRepository.findById(paymentId).get();
		payment.setMessage(null);
		payment.setMessageStatus(true);

		return payment;
	}

	public Iterable<Payment> getPayment() {
		return paymentRepository.findAll();
	}

	
}
