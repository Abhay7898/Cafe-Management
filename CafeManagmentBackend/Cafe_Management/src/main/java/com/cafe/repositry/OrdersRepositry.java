package com.cafe.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.model.Orders;

public interface OrdersRepositry extends JpaRepository<Orders, Integer>{
	//Orders getOrderByUserName(String userName);
}
