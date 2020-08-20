package com.order.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.controller.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{


}
