package com.cafe.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.model.Booking;
import com.cafe.repositry.BookingRepositry;
import com.cafe.services.BookingService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

	@Autowired
	public BookingRepositry bookingRepositry;

	@Override
	public Booking addBooking(Booking booking) {
		return bookingRepositry.save(booking);
	}

	@Override
	public boolean deleteBooking(int id) {
		if (bookingRepositry.existsById(id)) {
			try {
				bookingRepositry.deleteById(id);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

	/*
	 * @Override public Booking findBookingByUserNameAndTableNo(String userName, int
	 * tableNo) { Booking booking =
	 * bookingRepositry.findBookingByUserNameAndTableNo(userName, tableNo); return
	 * booking == null ? null : booking; }
	 */

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepositry.findAll();
	}

	@Override
	public Booking getBookingById(int id) {
		try {
			return bookingRepositry.findById(id).get();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateBooking(Booking booking) {
		Optional<Booking> check = bookingRepositry.findById(booking.getId());
		if (check.isPresent()) {
			Booking old = check.get();
			old.setId(booking.getId());
			old.setUserName(booking.getUserName());
			old.setEmailID(booking.getEmailID());
			old.setNoOfPeople(booking.getNoOfPeople());
			old.setSpecialRequest(booking.getSpecialRequest());
			old.setDate(booking.getDate());
			try {
				bookingRepositry.save(old);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}
}
