package com.gobs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gobs.api.bean.Address;
import com.gobs.api.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public Address getAddress(String addressid)
	{
		return repository.getAddress(addressid);
	}
}
