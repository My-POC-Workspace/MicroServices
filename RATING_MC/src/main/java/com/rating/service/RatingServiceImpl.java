package com.rating.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.midi.VoiceStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rating.model.Rating;
import com.rating.model.UserDTO;
import com.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Rating saveRating(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepository.save(rating);
	}

	@Override
	public Rating getRating(String id) {
		return ratingRepository.findByratingId(id);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUser(String userId) {
		return ratingRepository.findByuserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		return ratingRepository.findByhotelId(hotelId);
	}
	
	@Override
	public void delteRatingByUserId(String id) {
		if(ratingRepository.findByuserId(id) != null) {
			System.out.println("in delete by user id...");
			ratingRepository.deleteByuserId(id);
//			ratingRepository.deleteByuserId(id);
		}
		
	}
	
	//URL --> http://localhost:9000/user/getAllUsers
	public void finddd() {
		 UserDTO[] users= restTemplate.getForObject("http://localhost:9000/user/getAllUsers", UserDTO[].class);
		 List<UserDTO> list = Arrays.stream(users).toList();
		 
		List<Rating> findAll = ratingRepository.findAll();
		
		List<String> map = findAll.stream().map(e -> e.getUserId()).collect(Collectors.toList());
		
		
		
		
		
		
	}

}
