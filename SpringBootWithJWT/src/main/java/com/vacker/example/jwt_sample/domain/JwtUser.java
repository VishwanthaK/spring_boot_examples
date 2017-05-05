package com.vacker.example.jwt_sample.domain;

import java.util.Collection;

import org.joda.time.LocalDateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

    
	private static final long serialVersionUID = 6572114245032333694L;
	
	private final Long id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private String phone_number;
    private String username;
    private final String password;
    private final LocalDateTime registeredOn;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    

    public JwtUser(
          Long id,
          String firstname,
          String lastname,
          String email,
          String phone_number,
          String username,
          String password, 
          LocalDateTime registeredOn,
          Collection<? extends GrantedAuthority> authorities,
          boolean enabled) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.registeredOn = registeredOn;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone_number() {
		return phone_number;
	}

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

	@JsonIgnore
	public LocalDateTime getRegisteredOn() {
		return registeredOn;
	}
}
