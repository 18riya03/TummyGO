package com.riya.service;

import java.util.List;

import com.riya.model.Notification;
import com.riya.model.Order;
import com.riya.model.Restaurant;
import com.riya.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
