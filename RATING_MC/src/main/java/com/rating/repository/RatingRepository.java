package com.rating.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rating.model.Rating;

//public interface HotelRepository extends MongoRepository<Rating, String>{ --> for mongoDB
//	
//}

@Repository
public interface RatingRepository extends JpaRepository<Rating, String>{
	
	Rating findByratingId(String id);
	
	List<Rating> findByuserId(String userId);
	
	List<Rating> findByhotelId(String hotelId);
	
//	void deleteByuserId(@Param("id") String id);
	@Transactional   // Whenever we are doing DML transaction or any transaction that is going to modifying the DB, we need to use @Transactional and @Modifying
	@Modifying
	@Query("delete from Rating r where r.userId = :userId")
	void deleteByuserId(@Param("userId") String userId);

}
