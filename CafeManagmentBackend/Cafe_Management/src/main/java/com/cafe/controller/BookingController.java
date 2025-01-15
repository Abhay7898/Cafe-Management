package com.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.model.Booking;
import com.cafe.servicesimpl.BookingServiceImpl;
import com.cafe.utils.Massage;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class BookingController {
	
	/*
	 * @GetMapping(path = "/findBooking") public ResponseEntity<?>
	 * findBookingByUserNameAndTableNo(@Param("userName") String userName,
	 * 
	 * @Param("tableNo") int tableNo) { Booking check =
	 * bookingServiceImpl.findBookingByUserNameAndTableNo(userName, tableNo); return
	 * check==null?new
	 * ResponseEntity<>(Massage.NO_DATA_FOUND,HttpStatus.BAD_REQUEST):new
	 * ResponseEntity<>(check,HttpStatus.OK); }
	 */

	@Autowired
	public BookingServiceImpl bookingServiceImpl;

	@PostMapping(path = "/addBooking")
	public ResponseEntity<?> addBooking(@RequestBody Booking booking) {
		log.info("Add Booking API Call");
		Booking check = bookingServiceImpl.addBooking(booking);
		return check == null ? new ResponseEntity<>(Massage.TABLE_NOT_AVAILABLE, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(check, HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteBooking")
	public ResponseEntity<?> deleteBooking(@PathVariable int id) {
		log.info("Delete Booking API Call");
		boolean check = bookingServiceImpl.deleteBooking(id);
		return check ? new ResponseEntity<>(Massage.DATA_DELETED_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}


	@GetMapping(path = "/getAllBooking")
	public ResponseEntity<?> getAllBooking() {
		List<Booking> check=bookingServiceImpl.getAllBooking();
		return check.isEmpty()?new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST):new ResponseEntity<>(check, HttpStatus.OK);
	}

	@GetMapping(path = "/getBookingById")
	public ResponseEntity<?> getBookingById(@PathVariable int id) {
		Booking check=bookingServiceImpl.getBookingById(id);
		return check==null?new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST):new ResponseEntity<>(check, HttpStatus.OK); 
	}

	@PutMapping(path = "/updateBooking")
	public ResponseEntity<?> updateBooking(@RequestBody Booking booking) {
		boolean check=bookingServiceImpl.updateBooking(booking);
		return check?new ResponseEntity<>(Massage.DATA_UPDATED_SUCCESSFULLY,HttpStatus.OK):new ResponseEntity<>(Massage.NO_DATA_FOUND,HttpStatus.BAD_REQUEST);
	}
}
