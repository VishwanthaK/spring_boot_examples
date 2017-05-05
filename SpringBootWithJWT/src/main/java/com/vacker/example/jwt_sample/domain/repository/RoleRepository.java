package com.vacker.example.jwt_sample.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vacker.example.jwt_sample.domain.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("SELECT role from Role role WHERE role.name = ?1")
	Role getAuthorityByName(String name);
	
	

}
