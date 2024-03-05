package com.cafe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table
public class Orders{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String modeOfPayment;
	private String address;
	private String mobileNumber;
	private int quantityOfIteams;
}
