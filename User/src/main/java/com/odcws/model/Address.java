package com.odcws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "addresses")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Address {
	
	private String addId;
	
	private String addLine_1;
	
	private String addLine_2;
	
	private String landMark;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
}
