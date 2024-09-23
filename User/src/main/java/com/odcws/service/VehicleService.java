package com.odcws.service;

import java.util.Optional;

import com.odcws.model.Vehicle;

public interface VehicleService {
	
	public Vehicle addVehicle(Vehicle vehicle);
	
	public Optional<Vehicle> getVehicle(Long vehId);
	
	public String removeVehicle(Long vehId);
	
	public Vehicle updateVehicle(Long vehId, Vehicle vehicleDetails);

}
