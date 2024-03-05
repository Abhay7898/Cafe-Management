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
	//private String password;
	private String firstName;
	/*
	 * private String lastName; private String mobileNumber; private String emailId;
	 * private String city; private String address;
	 * 
	 * @Lob private String image;
	 */
	//private String role;
	
	private boolean isNormalLogin = false;
	private boolean isAddminLogin = false;

}
