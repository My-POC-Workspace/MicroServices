package com.hotel.service;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);
	
	Hotel getHotel(String id);
	
	List<Hotel> getAllHotels();
	
	void deleteHotel(String id);
	
	Hotel updateHotel(Hotel hotel,String id);
	
	

}
