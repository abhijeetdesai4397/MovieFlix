package com.gobs.api.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gobs.api.bean.Review;
import com.gobs.api.exception.IntegerParseException;
import com.gobs.api.exception.media.MediaNotFoundException;
import com.gobs.api.exception.review.InvalidReviewRatingException;
import com.gobs.api.exception.review.ReviewNotFoundException;
import com.gobs.api.exception.user.UserNotFountException;
import com.gobs.api.repository.MediaRepository;
import com.gobs.api.repository.ReviewRepository;
import com.gobs.api.repository.UserRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository repository;
	@Autowired
	MediaRepository mediaRepository;
	@Autowired
	UserRepository userRepository;
	
	public List<Review> getAllReviews(String imdbId)
	{
		if(mediaRepository.getMediaByImdbID(imdbId)==null)
			throw new MediaNotFoundException("Media with "+ imdbId +" IMDB ID does not exist");
		return repository.getAllReviews(imdbId);
	}
	
	public List<Review> getAllReviews(String imdbId,String start,String size)
	{
		int startIndex=-1;
		int pageSize=-1;
		if(mediaRepository.getMediaByImdbID(imdbId)==null)
			throw new MediaNotFoundException("Media with "+ imdbId +" IMDB ID does not exist");
		
		try {
			if(start!=null)
				startIndex=Integer.parseInt(start);
		} catch (Exception e) {
			throw new IntegerParseException("Error convterting "+start+" to integer");
		}
		
		try {
			if(size!=null)
				pageSize=Integer.parseInt(size);
		} catch (Exception e) {
			throw new IntegerParseException("Error convterting "+size+" to integer");
		}
		List<Review> reviews= repository.getAllReviews(imdbId);
		if(startIndex==-1)
			startIndex=0;
		else if(startIndex>reviews.size())
			return null;
		if(pageSize==-1)
			pageSize=reviews.size();
		else if(startIndex+pageSize>reviews.size())
			pageSize=reviews.size();
		else
			pageSize=startIndex+pageSize;
		System.err.println(startIndex+" "+pageSize);
		return reviews.subList(startIndex, pageSize);
	}
	
	public Review getReview(String reviewId)
	{
		Review review=repository.getReview(reviewId);
		if(review==null)
			throw new ReviewNotFoundException("Reviw with "+ reviewId +" does not exist");
		return null;
	}
	
	@Transactional
	public Review createReview(Review review)
	{
		if(mediaRepository.getMediaByImdbID(review.getImdbID())==null)
			throw new MediaNotFoundException("Media with "+ review.getImdbID() +" IMDB ID does not exist");
		if(review.getUserEmail()!=null && userRepository.getUserByEmail(review.getUserEmail())==null)
			throw new UserNotFountException("User with "+ review.getUserEmail() +" Email does not exist");
		if(review.getRating()<0 || review.getRating()>5)
			throw new InvalidReviewRatingException("Review rating not valid");
		return repository.createReview(review);
	}
	
	@Transactional
	public Review updateReview(String reviewId, Review review)
	{
		Review reviewExist=repository.getReview(reviewId);
		if(reviewExist==null)
			throw new ReviewNotFoundException("Reviw with "+ reviewId +" does not exist");
		if(mediaRepository.getMediaByImdbID(review.getImdbID())==null)
			throw new MediaNotFoundException("Media with "+ review.getImdbID() +" IMDB ID does not exist");
		if(review.getUserEmail()!=null && userRepository.getUserByEmail(review.getUserEmail())==null)
			throw new UserNotFountException("User with "+ review.getUserEmail() +" Email does not exist");
		if(review.getRating()<0 || review.getRating()>5)
			throw new InvalidReviewRatingException("Review rating not valid");
		return repository.updateReview(review);
	}
}
