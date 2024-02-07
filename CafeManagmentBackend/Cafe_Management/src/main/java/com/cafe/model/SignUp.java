package com.cafe.model;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@JsonIgnore
	private Blob image;
	@Transient
	private boolean isUserLogin;
	@Transient
	private boolean isAddminLogin;
}
