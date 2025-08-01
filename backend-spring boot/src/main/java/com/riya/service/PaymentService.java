package com.riya.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.riya.model.Order;
import com.riya.model.PaymentResponse;

public interface PaymentService {

	PaymentResponse createRazorpayPaymentLink(Order order) throws RazorpayException;
}