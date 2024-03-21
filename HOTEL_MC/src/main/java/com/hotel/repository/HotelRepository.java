package com.hotel.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{
	
	@Transactional
	Hotel findByhotelId(String id);
	
	@Transactional   
	@Modifying
	@Query("delete from Hotel h where h.hotelId = :id")
	void deleteByhotelId(@Param("id") String id);

}
