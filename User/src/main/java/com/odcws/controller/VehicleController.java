package com.odcws.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odcws.model.Vehicle;
import com.odcws.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Vehicle>> getVehiclesByUserId(@PathVariable Long userId) {
//        List<Vehicle> vehicles = vehicleService.getVehiclesByUserId(userId);
//        return ResponseEntity.ok(vehicles);
//    }

	@GetMapping("/{vehId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehId) {
		Optional<Vehicle> vehicle = vehicleService.getVehicleById(vehId);
		return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

//    @PostMapping("/user/{userId}")
//    public ResponseEntity<Vehicle> createVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
//        Vehicle newVehicle = vehicleService.createVehicle(userId, vehicle);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle);
//    }

	@PutMapping("/{vehId}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long vehId, @RequestBody Vehicle vehicleDetails) {
		Vehicle updatedVehicle = vehicleService.updateVehicle(vehId, vehicleDetails);
		return ResponseEntity.ok(updatedVehicle);
	}

	@DeleteMapping("/{vehId}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehId) {
		vehicleService.removeVehicle(vehId);
		return ResponseEntity.noContent().build();
	}

}
