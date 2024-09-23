package com.odcws.controller;

import com.odcws.model.Address;
import com.odcws.model.User;
import com.odcws.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
		return ResponseEntity.ok(registeredUser);
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
    public Address addAddressToUser(@PathVariable Long userId, @RequestBody Address address) {
        return userService.addAddressToUser(userId, address);
    }
}
