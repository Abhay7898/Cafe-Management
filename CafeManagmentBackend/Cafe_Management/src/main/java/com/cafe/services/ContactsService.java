package com.cafe.services;

import java.util.List;

import com.cafe.model.About;
import com.cafe.model.Contacts;

public interface ContactsService {
	
	public Contacts addAbout(Contacts contacts);

	public boolean deleteContacts(int id);

	public Contacts findContacts(String userName, int tableNo);

	public List<Contacts> getAllContacts();

	public Contacts getContactsById(int id);

	public boolean updateContacts(Contacts contacts);

	public boolean deleteontactsById(int id);
}
