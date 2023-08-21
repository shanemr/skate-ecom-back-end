package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	Role findByName(String name);
}
