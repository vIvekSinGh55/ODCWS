package com.odcws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odcws.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
