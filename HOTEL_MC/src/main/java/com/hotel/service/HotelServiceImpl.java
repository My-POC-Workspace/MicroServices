package com.hotel.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setHotelId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRepository.findByhotelId(id);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public void deleteHotel(String id) {
		hotelRepository.deleteByhotelId(id);	
	}

	@Override
	@Transactional
	@Modifying
	public Hotel updateHotel(Hotel hotel, String id) {
		Hotel h = hotelRepository.findByhotelId(id);
		h.setName(hotel.getName());
		return h;
		
	}

}
