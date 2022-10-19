package com.ass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ass.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
