package com.user.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.model.Hotel;

@FeignClient(name = "https://localhost:9001")   // we can pass url also over here...
public interface HotelService {
	
	@GetMapping("/hotel/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);

}
