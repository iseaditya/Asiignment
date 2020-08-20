package com.order.proxy;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "OrderItem", url = "localhost:1008")
public interface OrderProxy {
	
	
	  
	  @PutMapping(value = "/updateOrder/{id}")
		public void updateOrder(@PathVariable("productCode") int productCode, @PathVariable("quantity") int quantity);


}
