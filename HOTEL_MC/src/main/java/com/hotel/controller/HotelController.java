package com.hotel.controller;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/saveHotel")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	@GetMapping("/getHotel/{id}")
	public Hotel getHotel(@PathVariable String  id) {
		return hotelService.getHotel(id);
	}
	
	@GetMapping("/getAllHotels")
	public List<Hotel> getHotels(){
		return hotelService.getAllHotels();
	}
	
	@DeleteMapping("/deleteHotel/{id}")
	public void destroyHotel(@PathVariable String id) {
		hotelService.deleteHotel(id);
	}
	
	@PutMapping("/updateHotel/{id}")
	public Hotel ModifyHotel(@RequestBody Hotel hotel,@PathVariable String id) {
		return hotelService.updateHotel(hotel, id);
	}

}
