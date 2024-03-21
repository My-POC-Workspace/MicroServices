package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.model.User;


public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser(Integer pageNumber,Integer pageSize);
	
	User getUserById(String id);
	
	void deleteUserById(String id);
	
	User updateUserById(User user ,String id);

}
