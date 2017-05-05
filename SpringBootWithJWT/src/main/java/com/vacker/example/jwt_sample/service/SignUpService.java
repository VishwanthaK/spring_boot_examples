package com.vacker.example.jwt_sample.service;

import com.vacker.example.jwt_sample.domain.model.User;

public interface SignUpService {
	
	public int createNewAccount(User newUser);
	
	public void saveUserRole(User createdUser);

}
