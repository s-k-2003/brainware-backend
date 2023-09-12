package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Login;

@Repository
public interface UserRepository extends JpaRepository<Login, String>{
	Login findByUsername(String username);
}
