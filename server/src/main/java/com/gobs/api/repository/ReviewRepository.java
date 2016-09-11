package com.gobs.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gobs.api.bean.Review;

@Repository
public class ReviewRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Review> getAllReviews(String imdbId)
	{
		TypedQuery<Review> query= entityManager.createNamedQuery("Review.getAllReviews",Review.class);
		query.setParameter("imdbID", imdbId);
		List<Review> reviewList = query.getResultList();
		return reviewList;
	}
	
	public Review getReview(String reviewId)
	{
		return entityManager.find(Review.class, reviewId);
	}
	
	public Review createReview(Review review)
	{
		entityManager.persist(review);
		return review;
	}
	
	public Review updateReview(Review review)
	{
		entityManager.merge(review);
		return review;
	}
}
