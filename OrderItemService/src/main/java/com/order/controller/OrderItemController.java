package com.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.exception.OrderNotFoundException;
import com.order.items.service.OrderItemServiceProxy;
import com.order.proxy.OrderProxy;
import com.order.service.OrderItemService;

@RestController
public class OrderItemController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	  private OrderProxy proxy;
	
	@Autowired
	OrderItemService orderService;

	@PostMapping(value = "/orderitem/save")
	public int createOrder(@RequestBody OrderItem orderItem) {
		log.info("Creating order details in the database.");
		
		int quantity = orderItem.getQuantity();
		int productCode = orderItem.getProductCode();
		
		System.out.println(orderItem.toString());
		orderService.saveOrder(orderItem);
		
		proxy.updateOrder(productCode, quantity);
		
		return orderItem.getProductCode();
	}
	//
	@GetMapping("/getOrderDetails/{id}")
    public OrderItem getOrderDetails(@PathVariable("id") int id) throws OrderNotFoundException{
		OrderItem orderItem = orderService.getOrderDetailsById(id);
        if(orderItem == null)
            throw new OrderNotFoundException();
        
        return orderItem;
    }
	

	@GetMapping(value = "/order/getall")
	public List<OrderItem> retrieveAllOrder() {
		return orderService.getAllOrder();
	}
	
	@GetMapping(value = "/order/getmsg")
	public String getHelloMsg() {
		return "Hello";
	}
	
	
	
}
