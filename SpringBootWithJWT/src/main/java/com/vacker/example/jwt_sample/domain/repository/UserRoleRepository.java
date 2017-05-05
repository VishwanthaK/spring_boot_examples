package com.vacker.example.jwt_sample.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacker.example.jwt_sample.domain.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>
{

}
