package com.virtualClass.App.controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtualClass.App.model.Payment;
import com.virtualClass.App.service.PaymentService;

import antlr.collections.List;

@RestController
@CrossOrigin
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/savePayment")
	public Payment savePayment(@RequestBody Payment payment) {
		try {
			payment = paymentService.saveOrUpdatePayment(payment);
			if (payment.isMessageStatus()) {
				payment.setMessage("Save Successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			payment.setMessage(e.getMessage());
			payment.setMessageStatus(false);
		}

		return payment;
	}

	@PutMapping("/UpdatePayment")
	public Payment updatePayment(@RequestBody Payment payment) {
		try {
			payment = paymentService.saveOrUpdatePayment(payment);
			if (payment.isMessageStatus()) {
				payment.setMessage("Update Successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			payment.setMessage(e.getMessage());
			payment.setMessageStatus(false);
		}

		return payment;
	}

	@GetMapping("/getPayment/{paymentId}")
	public Payment getPayment(@PathVariable int paymentId) {
		Payment payment;
		try {
			payment = paymentService.getPayment(paymentId);
		} catch (Exception e) {
			e.printStackTrace();
			payment = new Payment();
			payment.setMessage(e.getMessage());
			payment.setMessageStatus(false);
		}

		return payment;
	}

	/*
	@GetMapping("/getPaymentByYearMothAndClassId")
	public Iterable<Payment> getPaymentByYearMothAndClassId(@RequestBody Payment payment) {
		//ArrayList<Payment> payments =new ArrayList<>();
		
		Iterable<Payment> payments =new ArrayList<>();
		
		
		try {
			payments = paymentService.getPaymentByYearMothAndClassId(payment.getYear(), payment.getMonth(), payment.getClassid());
		} catch (Exception e) {
			e.printStackTrace();
			
			payment.setMessage(e.getMessage());
			payment.setMessageStatus(false);
			//payments.add(payment);
		}

		return payments;
	}

	*/
	@GetMapping("/getPayments")
	public Iterable<Payment> getPayments() {
		Iterable<Payment> payments;
		try {
			payments = paymentService.getPayment();
		} catch (Exception e) {
			e.printStackTrace();
			payments = null;
		}

		return payments;
	}

}
