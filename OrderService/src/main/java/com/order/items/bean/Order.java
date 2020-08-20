package com.order.items.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "order_table")
public class Order {

	@Id
	@GeneratedValue
	private int orderId;
	private String customername;
	private String orderDate; //
	private String shippingAddress;
	private String orderItem;
	private int total;
	
	public Order() {	}

	public Order(int orderId, String customername, String orderDate, String shippingAddress, String orderItem, int total) {
		this.orderId = orderId;
		this.customername = customername;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.orderItem = orderItem;
		this.total = total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customername=" + customername + ", orderDate=" + orderDate
				+ ", shippingAddress=" + shippingAddress + ", orderItem=" + orderItem + ", total=" + total + "]";
	}

	
}
