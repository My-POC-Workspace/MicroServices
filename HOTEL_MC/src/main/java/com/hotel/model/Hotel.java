package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hotels")
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
