package com.rating.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmOneToManyCollectionElementType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity   // @Document("user_ratings") ==> we use this instead of @Entity whenever we are using mongoDB 
public class Rating {
	
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private double rating;
	private String feedback;
	
}
