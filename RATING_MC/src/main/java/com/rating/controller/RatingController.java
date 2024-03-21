package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.model.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/saveRating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}
	
	@GetMapping("/getRating/{id}")
	public Rating getRatingById(@PathVariable String id) {
		return ratingService.getRating(id);
	}
	@GetMapping("/getAllRatings")
	public List<Rating> getAllRatings(){
		return ratingService.getAllRating();
	}
	
	@GetMapping("/User/{id}")
	public List<Rating> getRatingByUserId(@PathVariable String id){
		return ratingService.getAllRatingByUser(id);
	}
	
	@GetMapping("/hotel/{id}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String id){
		return ResponseEntity.ok(ratingService.getAllRatingByHotelId(id));
	}
	
	@DeleteMapping("/deleteRating/{id}")
	public String deleteRating(@PathVariable String id) {
		ratingService.delteRatingByUserId(id);
		return "Rating Deleted Successfully...";
	}
	
	@GetMapping("/Test")
	public Rating Test() {
		return new Rating("1","1","1",1,"proper");		
	}
	
	
	
	
}
