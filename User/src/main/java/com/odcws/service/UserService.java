package com.odcws.service;

import java.util.Optional;

import com.odcws.exception.UserNotFoundException;
import com.odcws.model.Address;
import com.odcws.model.User;
import com.odcws.model.Vehicle;

public interface UserService {
    public User registerUser(User user) ;
    public Optional<User> loginUser(String email, String password) throws UserNotFoundException ;
    public User updateUser(Long userId, User updatedUserInfo);
    public Optional<User> getUserById(Long userId) ;
    public Address addAddressToUser(Long userId, Address address);
    public Vehicle addVehicleToUser(Long userId, Vehicle vehicle);
    //public User updateUser(Long userId, User updatedUserInfo) {
}
