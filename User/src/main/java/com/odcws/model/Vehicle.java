package com.odcws.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehId;
	
	private String vehNo;
	
	private String vehName;
	
	private String vehModel;
	
	private String vehType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
	@JsonBackReference
    private User user;

}
