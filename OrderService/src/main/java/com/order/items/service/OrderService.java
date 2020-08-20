package com.order.items.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.items.bean.Order;
import com.order.items.controller.OrderItem;
import com.order.items.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public void saveOrder(final Order order) {
		orderRepository.save(order);
	}

	
	public void updateOrder(int productCode, int quantity){
		OrderItem orderItem= orderRepository.findOne(productCode);
		int quantityValue = orderItem.getQuantity()-quantity;
		
		orderItem.setQuantity(orderItem.getQuantity());
		
		orderRepository.save(orderItem);
	}
	
	public List<Order> getAllOrder() {
		final List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(order -> orders.add(order));
		return orders;
	}
}

