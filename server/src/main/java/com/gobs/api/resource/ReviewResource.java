package com.gobs.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gobs.api.bean.Review;
import com.gobs.api.service.ReviewService;

@RestController
@RequestMapping(value="/reviews", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReviewResource {
	
	@Autowired
	ReviewService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/{imdbId}")
	public List<Review> getAllReviews(@PathVariable("imdbId") String imdbId,
									@RequestParam(value="start", required=false)String start, 
									@RequestParam(value="size", required=false)String size)
	{
		if(start==null && size==null)
			return service.getAllReviews(imdbId);
		return service.getAllReviews(imdbId,start,size);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review createReview(@RequestBody Review review)
	{
		return service.createReview(review);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{reviewId}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review updateReview(@PathVariable("reviewId") String reviewId, @RequestBody Review review)
	{
		return service.updateReview(reviewId,review);
	}

}
