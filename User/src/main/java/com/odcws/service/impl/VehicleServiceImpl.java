package com.odcws.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcws.model.Vehicle;
import com.odcws.repository.VehicleRepository;
import com.odcws.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicle.getVehId());
		if (existingVehicle.isPresent()) {
			throw new RuntimeException("Vehicle with Id " + vehicle.getVehId() + " already exists.");
		}
		return vehicleRepository.save(vehicle);
	}

	@Override
	public String removeVehicle(Long vehId) {
		if (vehicleRepository.existsById(vehId)) {
			vehicleRepository.deleteById(vehId);
			return "Vehicle with ID " + vehId + " removed successfully.";
		} else {
			return "Vehicle with ID " + vehId + " not found.";
		}
	}

	@Override
	public Optional<Vehicle> getVehicleById(Long vehId) {
		return vehicleRepository.findById(vehId);
	}

	@Override
	public Vehicle updateVehicle(Long vehId, Vehicle vehicleDetails) {
		Vehicle vehicle = vehicleRepository.findById(vehId)
				.orElseThrow(() -> new RuntimeException("Vehicle not found with ID " + vehId));

		vehicle.setVehNo(vehicleDetails.getVehNo());
		vehicle.setVehName(vehicleDetails.getVehName());
		vehicle.setVehModel(vehicleDetails.getVehModel());
		vehicle.setVehType(vehicleDetails.getVehType());

		return vehicleRepository.save(vehicle);
	}

}
