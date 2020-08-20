package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.controller.OrderItem;
import com.order.repo.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderRepository;

	public void saveOrder(final OrderItem orderItem) {
		orderRepository.save(orderItem);
	}

	
	//
	public OrderItem getOrderDetailsById(int id){
        return orderRepository.getOrderDetails(id);
    }
	
	public List<OrderItem> getAllOrder() {
		final List<OrderItem> orderItems = new ArrayList<>();
		orderRepository.findAll().forEach(orderItem -> orderItems.add(orderItem));
		return orderItems;
	}
}

