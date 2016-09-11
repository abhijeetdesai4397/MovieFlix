package com.gobs.api.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gobs.api.bean.User;
import com.gobs.api.service.UserService;

@RestController
@RequestMapping(value="/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRecource {

	@Autowired
	UserService service;
	// Get all user
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers()
	{
		
		return service.getAllUsers();
	}
	
	// Get single user
	@RequestMapping(method=RequestMethod.GET, value="/{userid}")
	public User getUser(@PathVariable("userid") String userid)
	{
		User user=service.getUser(userid);
		return user;
	}

	// Create new user
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User creatUser(@RequestBody User user)
	{
		return service.creatUser(user);
	}
	
	// update user
	@RequestMapping(method=RequestMethod.PUT, value="/{userid}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser(@PathVariable("userid") String userid,@RequestBody User user)
	{
		return service.updateUser(userid,user);
	}
}
