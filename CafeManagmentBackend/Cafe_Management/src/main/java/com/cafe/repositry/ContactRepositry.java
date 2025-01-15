package com.cafe.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.model.Contacts;

public interface ContactRepositry extends JpaRepository<Contacts, Integer>{

}
