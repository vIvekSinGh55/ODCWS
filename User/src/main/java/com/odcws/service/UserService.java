package com.odcws.service;

import java.util.Optional;

import com.odcws.model.Address;
import com.odcws.model.User;

public interface UserService {
    public User registerUser(User user) ;
    public Optional<User> loginUser(String email, String password) ;
    public User updateUser(Long userId, User updatedUserInfo);
    public Optional<User> getUserById(Long userId) ;
    public Address addAddressToUser(Long userId, Address address);
    //public User updateUser(Long userId, User updatedUserInfo) {
}
