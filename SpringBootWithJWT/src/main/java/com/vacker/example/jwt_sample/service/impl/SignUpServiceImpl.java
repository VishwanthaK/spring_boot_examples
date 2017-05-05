package com.vacker.example.jwt_sample.service.impl;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vacker.example.jwt_sample.domain.model.Role;
import com.vacker.example.jwt_sample.domain.model.User;
import com.vacker.example.jwt_sample.domain.model.UserRole;
import com.vacker.example.jwt_sample.domain.repository.RoleRepository;
import com.vacker.example.jwt_sample.domain.repository.UserRepository;
import com.vacker.example.jwt_sample.domain.repository.UserRoleRepository;
import com.vacker.example.jwt_sample.service.SignUpService;

@Service("userSignUpService")
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public int createNewAccount(User newUser) {
		
		try {
			newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
			newUser.setRegisteredOn(LocalDateTime.now());
			newUser.setUsername(newUser.getEmail());
			newUser.setEnabled(true);
			newUser = userRepository.saveAndFlush(newUser);
			saveUserRole(newUser);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public void saveUserRole(User createdUser) {
		UserRole userRoleMapping = new UserRole();
		try {
			Role role = roleRepository.getAuthorityByName("ROLE_USER");
			userRoleMapping.setAuthority(role);
			userRoleMapping.setUser(createdUser);
			userRoleRepository.saveAndFlush(userRoleMapping);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
