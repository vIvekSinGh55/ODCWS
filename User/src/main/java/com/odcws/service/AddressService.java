package com.odcws.service;

import java.util.Optional;

import com.odcws.model.Address;

public interface AddressService {
	
	public Address addAddress(Address address);
	
	public Optional<Address> getAddress(Long addId);
	
	public String removeAddress(Long addId);
	
	public Address updateAddress(Long addId, Address addressDetails);
	
	public Optional<Address> getAddressByUserId(Long userId);

}
