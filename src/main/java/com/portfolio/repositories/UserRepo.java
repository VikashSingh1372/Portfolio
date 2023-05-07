package com.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.portfolio.models.User;

public interface UserRepo   extends JpaRepository<User, Integer> {
	
	
	
	@Query("select u from User u where u.email =:email")
	public User getuserByUserName(@Param("email") String email);

}
