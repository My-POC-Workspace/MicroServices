package com.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//@Query("select u from User u where u.userId = :userId ")
	User findByuserId(@Param("userId") String userId);
	
	@Transactional   // Whenever we are doing DML transaction or any transaction that is going to modifying the DB, we need to use @Transactional and @Modifying
	@Modifying
	@Query("delete from User u where u.userId = :userId")
	void deleteByuserId(@Param("userId") String userId);

}
