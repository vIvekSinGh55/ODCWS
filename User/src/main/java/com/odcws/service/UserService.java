package com.odcws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.odcws.exception.UserNotFoundException;
import com.odcws.model.Address;
import com.odcws.model.User;
import com.odcws.model.Vehicle;

public interface UserService {
    public User registerUser(User user) ;
    public Optional<User> loginUser(String email, String password) throws UserNotFoundException ;
    public User updateUser(Long userId, User updatedUserInfo);
    public Optional<User> getUserById(Long userId) ;
//    public List<User> getAllUsers();
    public Page<User> getAllUsers(int page, int size);
    public Address addAddressToUser(Long userId, Address address);
    public Vehicle addVehicleToUser(Long userId, Vehicle vehicle);
    //public User updateUser(Long userId, User updatedUserInfo) {
}
