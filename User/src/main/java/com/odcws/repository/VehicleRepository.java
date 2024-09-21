package com.odcws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odcws.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
