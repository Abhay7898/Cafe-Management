package com.cafe.services;

import java.util.List;

import com.cafe.model.Orders;

public interface OrderService {
	
	public Orders addOrders(Orders orders);
	
	public List<Orders> getAllOrders();
	
	public Orders getOrderById(int id);
	
	public boolean updateOrder(Orders orders);
	
	public boolean deleteOrder(int id);
	
	//public Orders getOrderByUserName();
}
