package com.cafe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cafe.model.Orders;

public class OrderController {
	
	@PostMapping(path = "/addOrders")
	public Orders addOrders(@RequestBody Orders orders) {
		return null;
	}
	
	@GetMapping(path = "/getAllOrders")
	public List<Orders> getAllOrders() {
		return null;
	}
	
	@GetMapping(path = "/getAllOrders/{id}")
	public Orders getOrderById(@PathVariable int id) {
		return null;
	}
	
	@PutMapping(path = "/updateOrder")
	public boolean updateOrder(@RequestBody Orders orders) {
		return false;
	}
	
	@DeleteMapping(path = "/deleteOrder/{id}")
	public boolean deleteOrder(@PathVariable int id) {
		return false;
	}
	
	@GetMapping(path = "/getOrderByUserName/{}")
	public Orders getOrderByUserName() {
		return null;
	}
}
