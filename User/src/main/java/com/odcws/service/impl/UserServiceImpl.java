package com.odcws.service.impl;

import com.odcws.exception.UserNotFoundException;
import com.odcws.model.Address;
import com.odcws.model.User;
import com.odcws.model.Vehicle;
import com.odcws.repository.AddressRepository;
import com.odcws.repository.UserRepository;
import com.odcws.repository.VehicleRepository;
import com.odcws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	// Register user
	@Override
	public User registerUser(User user) {
		Optional<User> existingUser = userRepository.findByUserEmail(user.getUserEmail());
		if (existingUser.isPresent()) {
			throw new RuntimeException("User with email " + user.getUserEmail() + " already exists.");
		}
		return userRepository.save(user);
	}

	// Login user
	@Override
	public Optional<User> loginUser(String email, String password) throws UserNotFoundException {
		Optional<User> userOpt = userRepository.findByUserEmail(email);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			if (user.getUserPassword().equals(password)) {
				return Optional.of(user);
			} else {
				throw new UserNotFoundException("Invalid password.");
			}
		}
		return Optional.empty();
	}

	// Update user information
	@Override
	public User updateUser(Long userId, User updatedUserInfo) {
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			user.setUserFirstName(updatedUserInfo.getUserFirstName());
			user.setUserLastName(updatedUserInfo.getUserLastName());
			user.setUserEmail(updatedUserInfo.getUserEmail());
			user.setUserPassword(updatedUserInfo.getUserPassword());
			user.setUserMobileNo(updatedUserInfo.getUserMobileNo());
			return userRepository.save(user);
		} else {
			throw new RuntimeException("User not found.");
		}

	}

	// Optional method to fetch user by ID
	@Override
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public Address addAddressToUser(Long userId, Address address) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID " + userId));

		address.setUser(user); // Set the user in the address
		return addressRepository.save(address); // Save the address
	}

	@Override
	public Vehicle addVehicleToUser(Long userId, Vehicle vehicle) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID " + userId));
		vehicle.setUser(user); // Associate the vehicle with the fetched user
		return vehicleRepository.save(vehicle);
	}
}
