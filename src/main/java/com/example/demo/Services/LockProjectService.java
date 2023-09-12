package com.example.demo.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.LockedProjects;

import com.example.demo.Repository.LockedProjectsRepository;

@Service
public class LockProjectService {
	@Autowired
	LockedProjectsRepository lockedRepo;
	public LockedProjects create(LockedProjects details) {
		
		return lockedRepo.save(details);
	}
	
}
