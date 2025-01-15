package com.cafe.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.model.Booking;

public interface BookingRepositry extends JpaRepository<Booking, Integer>{
	
	//Booking findBookingByUserNameAndTableNo(String userName, int tableNo);
}
