package com.vacker.example.jwt_sample.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vacker.example.jwt_sample.domain.BaseModel;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseModel {
	
	private static final long serialVersionUID = -9213378036888865149L;
	
	private User user;
	private Role authority;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="role_id")
	public Role getAuthority() {
		return authority;
	}
	public void setAuthority(Role authority) {
		this.authority = authority;
	}
	
	
	

}
