package com.gobs.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gobs.api.bean.Address;
import com.gobs.api.bean.User;
import com.gobs.api.repository.UserRepository;

import oracle.net.aso.a;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	//@Transactional
	public List<User> getAllUsers()
	{
		/*System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		User user=new User();
		Address address=new Address();
		address.setId("abc");
		address.setAddress1("Abc");
		address.setAddress1("Abc");
		address.setCity("abc");
		address.setCountry("abc");
		address.setState("abc");
		user.setAddress(address);
		user.setAdmin(false);
		user.setId("abc");
		user.setEmail("abc");
		user.setFirstName("abc");
		user.setLastName("abc");
		user.setPassword("abc".toCharArray());
		user.setPhoneNo("abc");
		repository.creatUser(user);
		System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");*/
		return repository.getAllUsers();
	}
	
	public User getUser(String userid)
	{
		return repository.getUser(userid);
	}
	
	@Transactional
	public User creatUser(User user)
	{
		return repository.creatUser(user);
	}
	
	@Transactional
	public User updateUser(User user)
	{
		return repository.updateUser(user);
	}
}
