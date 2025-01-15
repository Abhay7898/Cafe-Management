package com.cafe.services;

import java.util.List;

import com.cafe.model.Booking;
import com.cafe.model.SignUp;

public interface BookingService {
	
	public Booking addBooking(Booking booking);
	
	public boolean deleteBooking(int id);

	//public Booking findBookingByUserNameAndTableNo(String userName, int tableNo);

	public List<Booking> getAllBooking();

	public Booking getBookingById(int id);

	public boolean updateBooking(Booking booking);

}
