package com.cafe.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.model.Orders;
import com.cafe.model.SignUp;
import com.cafe.repositry.OrdersRepositry;
import com.cafe.services.OrderService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrdersRepositry ordersRepositry;

	@Override
	public List<Orders> getAllOrders() {
		try {
			return ordersRepositry.findAll();	
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders getOrderById(int id) {
		return ordersRepositry.findById(id).get();
	}

	@Override
	public boolean updateOrder(Orders orders) {
		Optional<Orders> check=ordersRepositry.findById(orders.getId());
		if(check.isPresent()) {
			Orders oldOrders=check.get();
			oldOrders.setId(orders.getId());
			oldOrders.setMobileNumber(orders.getMobileNumber());
			oldOrders.setAddress(orders.getAddress());
			oldOrders.setModeOfPayment(orders.getModeOfPayment());
			orders.setQuantityOfIteams(orders.getQuantityOfIteams());
			try {
				ordersRepositry.save(oldOrders);
				return true;
			}catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteOrder(int id) {
		if(ordersRepositry.existsById(id)) {
			try {
				ordersRepositry.deleteById(id);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return  false;
	}
	
	@Override
	public Orders addOrders(Orders orders) {
		return ordersRepositry.save(orders);
	}
	
	/*
	 * @Override public Orders getOrderByUserName() { return
	 * ordersRepositry.getOrderByUserName(signUp.getFirstName()); }
	 */


}
