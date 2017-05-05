package com.vacker.example.jwt_sample.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vacker.example.jwt_sample.domain.JwtUser;
import com.vacker.example.jwt_sample.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Value("${nbano.token.header}")
    private String tokenHeader;
	
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get_details", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
    	String token = request.getHeader(tokenHeader);
        return userService.getUserDetails(token);
    }

}
