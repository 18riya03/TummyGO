package com.riya.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.riya.model.Order;
import com.riya.model.PaymentResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation implements PaymentService{

	@Value("${razorpay.api.key}")
	private String apiKey;

	@Value("${razorpay.api.secret}")
	private String apiSecret;

	@Override
	public PaymentResponse createRazorpayPaymentLink(Order order) throws RazorpayException {
		Long amount = order.getTotalAmount() * 100;


		try {
			// Instantiate a Razorpay client with your key ID and secret
			RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecret);

			JSONObject paymentLinkRequest = new JSONObject();
			paymentLinkRequest.put("amount",amount);
			paymentLinkRequest.put("currency","INR");

			// Create a JSON object with the customer details
			JSONObject customer = new JSONObject();
			customer.put("name",order.getCustomer().getFullName());

			customer.put("email",order.getCustomer().getEmail());
			paymentLinkRequest.put("customer",customer);

			// Create a JSON object with the notification settings
			JSONObject notify = new JSONObject();
			notify.put("email",true);
			paymentLinkRequest.put("notify",notify);

			// Set the reminder settings
			paymentLinkRequest.put("reminder_enable",true);

			// Set the callback URL and method
			paymentLinkRequest.put("callback_url","http://localhost:3000/payment/success/"+order
					.getId());
			paymentLinkRequest.put("callback_method","get");

			PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

			String paymentLinkUrl = payment.get("short_url");
			String paymentLinkId = payment.get("id");



			System.out.println("payment ----- "+payment);

//			return payment;

			PaymentResponse res = new PaymentResponse();
			res.setPayment_url(payment.get("short_url"));

			return res;
		} catch (RazorpayException e) {

			System.out.println("Error creating payment link: " + e.getMessage());
			throw new RazorpayException(e.getMessage());
		}
	}

}
