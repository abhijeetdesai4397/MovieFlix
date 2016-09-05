package com.gobs.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gobs.api.bean.User;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	public List<User> getAllUsers()
	{
		//TypedQuery<User> query= entityManager.createNamedQuery("User.getAllUsers", User.class);
		Query query=entityManager.createNamedQuery("Users.finaAll");
		return query.getResultList();
	}
	
	public User getUser(String userid)
	{
		System.out.println(userid);
		return entityManager.find(User.class, userid);
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
