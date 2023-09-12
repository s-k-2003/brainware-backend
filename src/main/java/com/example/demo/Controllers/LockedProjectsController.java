package com.example.demo.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.LockedProjects;
import com.example.demo.Repository.LockedProjectsRepository;
import com.example.demo.Services.LockProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/locked")
@CrossOrigin(origins="http://localhost:3000")
public class LockedProjectsController {
	@Autowired
	LockProjectService lockprojectService;
	@Autowired
	LockedProjectsRepository lockRepo;
	
	@Operation(summary = "Creates a new Project")
	
	
	@ApiResponses(value = 
{
		@ApiResponse(responseCode = "201",description="Project created sucessfull"),
		@ApiResponse(responseCode = "401", description="Projectprojectid is Invalprojectid"),
		@ApiResponse(responseCode = "404", description="Projectprojectid Not Found")
})
	
	
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(produces = "application/json", consumes="application/json")
	public ResponseEntity<LockedProjects> create(final @RequestBody LockedProjects lockedprojects){
		LockedProjects locked = lockprojectService.create(lockedprojects);
		return ResponseEntity.ok(locked);
	}
	
	public LockedProjectsController(LockedProjectsRepository lockRepo) {
		this.lockRepo = lockRepo;
	}
	@Operation(summary = "Get the Project by given projectid")
	@GetMapping(value = "/{username}", produces = "application/json")
	
	public List<LockedProjects> lockedprojects(@PathVariable String username){
		return lockRepo.findByUsername(username);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProjects(@PathVariable Long id) {
		lockRepo.deleteById(id);
	}
}
