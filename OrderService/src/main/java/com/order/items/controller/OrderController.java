package com.order.items.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.items.bean.Order;
import com.order.items.bean.OrderItemServiceBean;
import com.order.items.service.*;

@RestController
public class OrderController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	  @Autowired 
	  private OrderItemServiceProxy proxy;
	  
	  @Autowired OrderItemProxy orderProxy;
	 
	@Autowired
	OrderService orderService;

	@PostMapping(value = "/order/save")
	public int createOrder(@RequestBody Order order) {
		log.info("Creating order details in the database.");
		
		
		System.out.println(order.toString());
		orderService.saveOrder(order);
		return order.getOrderId();
	}
	
	//	

	@GetMapping(value = "/order/getall")
	public List<OrderItemServiceBean> retrieveAllOrder() {
		
		return proxy.retrieveAllOrder();
	}
	
	
	@PutMapping(value = "/updateOrder/{id}")
	public void updateOrder(@PathVariable("productCode") int productCode), @PathVariable("quantity") int quantity {

		orderService.updateOrder(int productCode, int quantity);
		
	}
	
	
	  @GetMapping(value = "/order/getOrderDetails/{id}") 
	  public OrderItemServiceBean getOrder() 
	  { 
		return orderProxy.getOrderDetails();  
	  }
}	  	  
