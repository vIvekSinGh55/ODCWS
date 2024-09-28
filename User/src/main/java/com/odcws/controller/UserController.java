package com.odcws.controller;

import com.odcws.exception.UserNotFoundException;
import com.odcws.model.Address;
import com.odcws.model.User;
import com.odcws.model.Vehicle;
import com.odcws.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password)
			throws UserNotFoundException {
		User user = userService.loginUser(email, password).get();
		return ResponseEntity.ok(user);
	}

	// Update user information
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
		User updatedUser = userService.updateUser(userId, user);
		return ResponseEntity.ok(updatedUser);
	}

//	@GetMapping("/users")
//	public List<User> getAllUsers() {
//		return userService.getAllUsers();
//	}
	
	@GetMapping("/users")
	public ResponseEntity<Map<String, Object>> getAllUser(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size)
	{
		Page<User> userPage = userService.getAllUsers(page, size);
		//Handling Pagination Response
		Map<String, Object> response = new HashMap<>();
        response.put("users", userPage.getContent());
        response.put("currentPage", userPage.getNumber());
        response.put("totalItems", userPage.getTotalElements());
        response.put("totalPages", userPage.getTotalPages());

        return ResponseEntity.ok(response);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		Optional<User> user = userService.getUserById(userId);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
