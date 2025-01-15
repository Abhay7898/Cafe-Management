package com.cafe.model;

import java.sql.Blob;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "team")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String memberName;
	private String designation;
	@JsonIgnore
	private Blob memberImage;
}
