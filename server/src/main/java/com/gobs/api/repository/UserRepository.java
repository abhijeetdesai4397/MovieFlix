package com.gobs.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gobs.api.bean.User;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	public List<User> getAllUsers()
	{
		TypedQuery<User> query= entityManager.createNamedQuery("User.getAllUsers", User.class);
		return query.getResultList();
	}
	
	public User getUser(String userid)
	{
		return entityManager.find(User.class, userid);
	}
	
	public User getUserByEmail(String email)
	{
		TypedQuery<User> query=entityManager.createNamedQuery("Users.getUserByEmail", User.class);
		query.setParameter("email", email);
		List<User> userList=query.getResultList();
		if(userList.size()==1)
			return userList.get(0);
		return null;
	}
	
	public User creatUser(User user)
	{
		entityManager.persist(user.getAddress());
		entityManager.persist(user);
		return user;
	}
	
	public User updateUser(User user)
	{
		entityManager.merge(user);
		return user;
	}
}
