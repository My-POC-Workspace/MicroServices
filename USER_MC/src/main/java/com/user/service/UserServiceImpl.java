package com.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.configuration.ServiceConf;
import com.user.exception.UserNotFound;
import com.user.externalservice.HotelService;
import com.user.externalservice.RatingService;
import com.user.model.Hotel;
import com.user.model.Rating;
import com.user.model.User;
import com.user.payload.ApiResponse;
import com.user.repository.UserRepository;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private RestTemplate restTemplate;

	private Optional<Rating> findFirst;

	@Override
	public User saveUser(User user) {
		// In real time project we generate userid like this but not by autogenerated by
		// dialect. That's why we create id as string but not long...
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser(Integer pageNumber, Integer pageSize) {

		List<User> findAll = new ArrayList<>();

		List<User> listOfUsers = userRepository.findAll();

		Rating[] ur = restTemplate.getForObject("https://RATING-SERVICE/rating/getAllRatings", Rating[].class);
		List<Rating> userRatings = Arrays.stream(ur).toList();
//		List<Rating> userRatings = ratingService.getAllRatings();

		userRatings.stream().map(r -> {
//			Hotel hotel = hotelService.getHotel(r.getHotelId());
			Hotel hotel = hotelService.getHotel(r.getHotelId());
			r.setHotel(hotel);
			return r;
		}).collect(Collectors.toList());

		for (int i = 0; i < listOfUsers.size(); i++) {
			User user = listOfUsers.get(i);
			String userId = user.getUserId();
			System.out.println("--> " + userRatings.get(i).getUserId());
			if ((userRatings.get(i).getUserId().equalsIgnoreCase(userId))) {
				user.setRatings(userRatings);
				findAll.add(user);
			} else {
				findAll.add(user);
			}
		}
		return findAll;

//		For Pagination --> follow below
//		PageRequest p = PageRequest.of(pageNumber, pageSize);
//		 return userRepository.findAll(p).getContent();
//		return userRepository.findAll();

	}

	@Override
	public User getUserById(String id) {
		User user = userRepository.findByuserId(id);// .orElseThrow( () -> new UserNotFound("User with id not
													// present...")); // Custom exception using java 8

		// Fetching ratings of user...
		// URL --> localhost:9002/rating/User/3eed97ff-3424-4b64-aeb8-de18940eda68

//	    ArrayList<Rating> userRatings = restTemplate.getForObject("http://localhost:9002/rating/User/" + user.getUserId() ,  ArrayList.class);  // to make it dynamic, we have to use user getter 		  
//		user.setRatings(userRatings);
		System.out.println("============================================");
//		Rating[] ratingsOfUser = restTemplate.getForObject("https://localhost:9022/rating/User/" + user.getUserId(),
//				Rating[].class); // to make it dynamic, we have to use user getter
//		List<Rating> userRating = Arrays.stream(ratingsOfUser).toList();
//		System.out.println("Working till here...");
		System.out.println("============================================");
		
		List<Rating> userRating = ratingService.getRatingByUserId(id);

		
		List<Rating> ratingList = userRating.stream().map(r -> {
		System.out.println("Working in map...-===============================");
//		ResponseEntity<Hotel> getHotel = restTemplate.getForEntity("https://HOTEL-SERVICE/hotel/getHotel/" + r.getHotelId(), Hotel.class);
//		Hotel getHotel = restTemplate.getForObject("https://HOTEL-SERVICE/hotel/getHotel/" + r.getHotelId(), Hotel.class);
		Hotel getHotel = hotelService.getHotel(r.getHotelId());
		System.out.println("Woking after map===============================");
//		Hotel hotel = getHotel.getBody();

			System.out.println("Working till here also ====================================================");
//			Hotel hotel = hotelService.getHotel(r.getHotelId());
			
			r.setHotel(getHotel);
			return r;

		}).collect(Collectors.toList());
//		user.setRatings(ratingList);

		user.setRatings(userRating);
		return user;
	}

	@Override
	public void deleteUserById(String id) throws UserNotFound {
		if (userRepository.findByuserId(id) != null) {

			ratingService.deleteRating(id);
			userRepository.deleteByuserId(id);

		} else
			throw new UserNotFound("User with id not present...");
	}

	@Override
	@Transactional
	@Modifying
	public User updateUserById(User user, String id) {
		User u = userRepository.findByuserId(id);
		if (u != null)
			u.setName(user.getName());
		else {
			throw new UserNotFound("User with id not present...");
		}
		return u;
	}

}
