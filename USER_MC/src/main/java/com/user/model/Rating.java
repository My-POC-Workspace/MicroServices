package com.user.model;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private double rating;
	private String feedback;
	
	@Transient
	private Hotel hotel;

}
