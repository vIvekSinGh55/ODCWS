package com.odcws.service.impl;


import com.odcws.model.User;
import com.odcws.repository.UserRepository;
import com.odcws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
    public Optional<User> loginUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByUserEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getUserPassword().equals(password)) {
                return Optional.of(user);
            } else {
                throw new RuntimeException("Invalid password.");
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
}
