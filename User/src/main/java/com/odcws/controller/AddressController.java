package com.odcws.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odcws.model.Address;
import com.odcws.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/user/{userId}")
	public ResponseEntity<Address> getAddressByUserId(@PathVariable Long userId) {
		Optional<Address> address = addressService.getAddressByUserId(userId);
		return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

//    @PostMapping("/user/{userId}")
//    public ResponseEntity<Address> createAddress(@PathVariable Long userId, @RequestBody Address address) {
//        Address newAddress = addressService.createAddress(userId, address);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
//    }

	@PutMapping("/user/{userId}")
	public ResponseEntity<Address> updateAddress(@PathVariable Long userId, @RequestBody Address addressDetails) {
		Address updatedAddress = addressService.updateAddress(userId, addressDetails);
		return ResponseEntity.ok(updatedAddress);
	}

	@DeleteMapping("/{addressId}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
		addressService.removeAddress(addressId);
		return ResponseEntity.noContent().build();
	}

}
