package com.cafe.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignUpDTO {

	private int id;
	private String userName;
	private String firstName;
	private boolean isAddminLogin = false;
	/*
	 * private String lastName; private String mobileNumber; private String emailId;
	 * private String city; private String address;
	 * 
	 * @Lob private String image;
	 */
	//private String role;
	//private String password;
}
