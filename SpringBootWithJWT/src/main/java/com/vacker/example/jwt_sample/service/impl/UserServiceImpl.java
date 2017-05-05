package com.vacker.example.jwt_sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.vacker.example.jwt_sample.domain.JwtUser;
import com.vacker.example.jwt_sample.domain.model.User;
import com.vacker.example.jwt_sample.domain.repository.UserRepository;
import com.vacker.example.jwt_sample.security.JwtTokenUtil;
import com.vacker.example.jwt_sample.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User getUserByToken(String token) {
		String username = null;
		User loggedInUser = null;
		username = jwtTokenUtil.getUsernameFromToken(token);
		loggedInUser = userRepository.findByUsername(username);
		return loggedInUser;
	}
	
	@Override
	public long getUserIdByToken(String token) {
		String username = null;
		User loggedInUser = null;
		username = jwtTokenUtil.getUsernameFromToken(token);
		loggedInUser = userRepository.findByUsername(username);
		return loggedInUser.getId();
	}
	
	@Override
	public JwtUser getUserDetails(String token) {
		String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
		return user;
	}
}
