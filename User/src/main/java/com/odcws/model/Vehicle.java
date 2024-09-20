package com.odcws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	private String vehId;
	
	private String vehNo;
	
	private String vehName;
	
	private String vehModel;
	
	private String vehType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

}
