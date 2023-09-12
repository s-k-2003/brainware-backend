package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.ClubAllocation;


@Repository
public interface ClubRepository extends JpaRepository<ClubAllocation, Integer>{
	List<ClubAllocation> findByroomcode(String roomcode);
	List<ClubAllocation> findByUsername(String username);
}
