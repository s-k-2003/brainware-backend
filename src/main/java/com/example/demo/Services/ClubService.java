package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.ClubAllocation;

import com.example.demo.Repository.ClubRepository;

@Service
public class ClubService {
	@Autowired
	ClubRepository clubRepo;
	
	public ClubAllocation create(ClubAllocation details) {
		
		return clubRepo.save(details);
	}
	
	
}
