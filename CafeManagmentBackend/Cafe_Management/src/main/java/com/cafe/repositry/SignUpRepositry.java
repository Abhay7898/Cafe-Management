package com.cafe.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.model.SignUp;

public interface SignUpRepositry extends JpaRepository<SignUp, Integer> {

	List<SignUp> findUserByUserName(String userName);
	
	SignUp findUserByUserNameAndPassword(String userName,String password);
}
