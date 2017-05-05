package com.vacker.example.jwt_sample.domain;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    
    private final Long user_id;

    public JwtAuthenticationResponse(String token, Long user_id) {
        this.token = token;
        this.user_id = user_id;
    }
    public String getToken() {
        return this.token;
    }
	public Long getUser_id() {
		return user_id;
	}
    
    
}
