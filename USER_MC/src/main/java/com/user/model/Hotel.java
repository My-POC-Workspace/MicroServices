package com.user.model;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	
	@Id
	private String hotelId;
	@Column(name = "HotelName")
	private String name;
	@Column(name = "HotelLocation")
	private String location;
	@Column(name = "AboutName")
	private String about;
}