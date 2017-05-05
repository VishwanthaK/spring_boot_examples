package com.vacker.example.jwt_sample.service;

import com.vacker.example.jwt_sample.domain.JwtUser;
import com.vacker.example.jwt_sample.domain.model.User;


public interface UserService {
	
	User getUserByToken(String token);
	
	long getUserIdByToken(String token);
	
	JwtUser getUserDetails(String token);
	
}
