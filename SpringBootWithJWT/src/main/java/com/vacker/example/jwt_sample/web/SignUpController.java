package com.vacker.example.jwt_sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vacker.example.jwt_sample.domain.model.User;
import com.vacker.example.jwt_sample.service.SignUpService;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	SignUpService signUpService;
	
	
	@RequestMapping(value = "/newuser", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody User newUser){
		int status = 0;
        status = signUpService.createNewAccount(newUser);
		if(status == 1)
			return new ResponseEntity<String>("User has been registered Successfully", HttpStatus.ACCEPTED);
		return new ResponseEntity<String>("Error", HttpStatus.EXPECTATION_FAILED);
	}
}
