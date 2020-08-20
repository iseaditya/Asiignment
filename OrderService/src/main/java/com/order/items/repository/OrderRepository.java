package com.order.items.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.items.bean.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
