package com.odcws.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcws.model.Address;
import com.odcws.repository.AddressRepository;
import com.odcws.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addRepository;

	@Override
	public Address addAddress(Address address) {
		Optional<Address> existingAddress = addRepository.findById(address.getAddId());
		if (existingAddress.isPresent()) {
			throw new RuntimeException("Address with Id " + address.getAddId() + " already exists.");
		}
		return this.addRepository.save(address);
	}

	@Override
	public Optional<Address> getAddress(Long addId) {
		return addRepository.findById(addId);
	}

	@Override
	public String removeAddress(Long addId) {
		if (addRepository.existsById(addId)) {
			addRepository.deleteById(addId);
			return "Address with ID " + addId + " removed successfully.";
		} else {
			return "Address with ID " + addId + " not found.";
		}
	}

	@Override
	public Address updateAddress(Long addId, Address addressDetails) {
		Address address = addRepository.findById(addId)
				.orElseThrow(() -> new RuntimeException("Address not found with ID " + addId));

		address.setAddLine_1(addressDetails.getAddLine_1());
		address.setAddLine_2(addressDetails.getAddLine_2());
		address.setLandMark(addressDetails.getLandMark());
		address.setCity(addressDetails.getCity());
		address.setState(addressDetails.getState());
		address.setCountry(addressDetails.getCountry());
		address.setPincode(addressDetails.getPincode());

		return addRepository.save(address);
	}

}
