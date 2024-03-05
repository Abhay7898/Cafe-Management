package com.cafe.services;

import java.util.List;

import com.cafe.model.About;
import com.cafe.model.Booking;

public interface AboutService {
	
	public About addAbout(About about);

	public boolean deleteAbout(int id);

	public About findAbout(String userName, int tableNo);

	public List<Booking> getAllBooking();

	public About getAboutById(int id);

	public boolean updateAbout(About about);

	public boolean deleteAboutById(int id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
