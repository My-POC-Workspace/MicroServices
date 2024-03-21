package com.rating.service;

import java.util.List;

import com.rating.model.Rating;

public interface RatingService {
	
	Rating saveRating(Rating rating);
	
	Rating getRating(String id);
	
	List<Rating> getAllRating();	
	
	List<Rating> getAllRatingByUser(String userId);
	
	List<Rating> getAllRatingByHotelId(String hotelId);
	
	void delteRatingByUserId(String id);

}
