package com.cafe.model;

import com.cafe.dto.SignUpDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "singup")
public class SignUp {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	@Transient
	private String confrimPassword;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;
	private String city;
	private String address;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	private String role="NORMAL";
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		SignUpDTO signUpDTO = new SignUpDTO();
		signUpDTO.setUserName(this.userName);
		signUpDTO.setFirstName(this.firstName);
		if(this.role.equals("ADMIN")) {
			signUpDTO.setAddminLogin(true);
		}
		return signUpDTO;
	}
}
