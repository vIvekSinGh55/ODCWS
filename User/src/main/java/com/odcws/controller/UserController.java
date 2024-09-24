package com.odcws.controller;

import com.odcws.model.Address;
import com.odcws.model.User;
import com.odcws.model.Vehicle;
import com.odcws.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Register a new user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User registeredUser = userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
	}

	// Login user
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
		User user = userService.loginUser(email, password).get();
		return ResponseEntity.ok(user);
	}

	// Update user information
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
		User updatedUser = userService.updateUser(userId, user);
		return ResponseEntity.ok(updatedUser);
	}

	@PostMapping("/{userId}/addresses")
	public ResponseEntity<Address> addAddressToUser(@PathVariable Long userId, @RequestBody Address address) {
		Address newAddress = userService.addAddressToUser(userId, address);
		return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
	}

	@PostMapping("/user/{userId}")
	public ResponseEntity<Vehicle> addVehicleToUser(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
		Vehicle newVehicle = userService.addVehicleToUser(userId, vehicle);
		return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle);
	}

}
