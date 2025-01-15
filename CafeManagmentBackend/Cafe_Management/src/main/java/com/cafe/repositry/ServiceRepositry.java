package com.cafe.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.model.Service;

public interface ServiceRepositry extends JpaRepository<Service, Integer>{

}
