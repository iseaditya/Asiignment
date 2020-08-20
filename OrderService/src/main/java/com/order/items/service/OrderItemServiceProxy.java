package com.order.items.service;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.order.items.bean.OrderItemServiceBean;

@FeignClient(name = "OrderItemService", url = "localhost:1008")
public interface OrderItemServiceProxy {
	
	
	  @GetMapping(value = "/order/getall") 
	  public List<OrderItemServiceBean> retrieveAllOrder();
	  
	 
	
	  //@GetMapping(value = "/order/getmsg") public String getHelloMsg();
	 

}
