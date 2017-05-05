package com.vacker.example.jwt_sample.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vacker.example.jwt_sample.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT user from User user WHERE user.username = ?1")
	User findByUsername(String username);
	
}
