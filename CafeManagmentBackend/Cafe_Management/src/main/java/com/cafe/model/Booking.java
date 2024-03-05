package com.cafe.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String emailID;
	private Date date;
	private int noOfPeople;
	private String specialRequest;
	@JsonIgnore
	@Transient
	private int tableNo;
}
