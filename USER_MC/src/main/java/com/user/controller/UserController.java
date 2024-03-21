package com.user.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.logging.LogManager;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.model.Rating;
import com.user.model.User;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return  userService.saveUser(user);
	}
	
//	@Cacheable(cacheNames = "user",key = "#id")
	@GetMapping("getUser/{id}")
	public User getUser(@PathVariable String id) {
		System.out.println("Fetching from DB...");
		System.out.println("in getuser......");
		return userService.getUserById(id);
		
	}                   
	
//	@Cacheable(cacheNames = "user")
	@GetMapping("/getAllUsers")
	public List<User> getUsers(@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
												@RequestParam(value = "pageSize",defaultValue = "2",required = false) Integer pageSize){
		return userService.getAllUser(pageNumber,pageSize);
	}
	
//	@CacheEvict(cacheNames = "user",key = "#id")
	@DeleteMapping("/deleteUser/{id}")
	public String destroyUser(@PathVariable String id) {
		userService.deleteUserById(id);
		return "User deleted successfully...";
	}
	
//	@CachePut(cacheNames = "user",key = "#id")
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable String id) {
		 return userService.updateUserById(user, id);
	}
	
	@GetMapping("/Test")
	public String Test() {
		return "It;s Working...";
	}
	
	@GetMapping("/ratingTest")
	public Rating test() {
		Rating rating = restTemplate.getForObject("https://localhost:9022/rating/Test", Rating.class);
		System.out.println(rating);
		return rating;
//		return "It's properly wotking....";
	}

}
