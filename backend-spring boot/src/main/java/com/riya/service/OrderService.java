package com.riya.service;

import java.util.List;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.riya.Exception.CartException;
import com.riya.Exception.OrderException;
import com.riya.Exception.RestaurantException;
import com.riya.Exception.UserException;
import com.riya.model.Order;
import com.riya.model.PaymentResponse;
import com.riya.model.User;
import com.riya.request.CreateOrderRequest;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException, RazorpayException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
