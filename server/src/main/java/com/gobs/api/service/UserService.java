package com.gobs.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gobs.api.bean.Address;
import com.gobs.api.bean.User;
import com.gobs.api.exception.address.AddressIDMissingException;
import com.gobs.api.exception.address.InvalidAddressIDException;
import com.gobs.api.exception.user.InvalidRequestException;
import com.gobs.api.exception.user.UserNotFountException;
import com.gobs.api.exception.user.UserWithEmailIDPresentException;
import com.gobs.api.repository.AddressRepository;
import com.gobs.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private AddressRepository addressRepository;
	public List<User> getAllUsers()
	{
			return repository.getAllUsers();
	}
	
	public User getUser(String userid)
	{
		User user=repository.getUser(userid);
		if(user==null)
			throw new UserNotFountException("User with given ID does not exist");
		return user;
	}
	
	@Transactional
	public User creatUser(User user)
	{
		User userExists=repository.getUserByEmail(user.getEmail());
		if(userExists!=null)
			throw new UserWithEmailIDPresentException("User with Email Id "+user.getEmail()+" already prenset");
		else
		{
			Address address=addressRepository.checkAddress(user.getAddress());
			if(address!=null)
				user.setAddress(address);
			return repository.creatUser(user);
		}
	}
	
	@Transactional
	public User updateUser(String userId, User user)
	{
		User userExists=repository.getUser(userId);
		if(userExists==null)
			throw new UserNotFountException("User with given ID does not exist");
		
		if(!user.getEmail().equals(userExists.getEmail()))
			throw new InvalidRequestException("Email ID in request and URL does not match");
		
		if(user.getAddress().getId()==null || user.getAddress().getId().isEmpty())
			throw new AddressIDMissingException("Address ID is missing in input JSON");
		
		Address address= addressRepository.getAddress(user.getAddress().getId());
		if(address==null)
			throw new InvalidAddressIDException("Address ID provided does not exist");
		
		Address addressExist=addressRepository.checkAddress(user.getAddress());
		if(addressExist!=null)
			user.setAddress(addressExist);
		return repository.updateUser(user);	
	}
}
