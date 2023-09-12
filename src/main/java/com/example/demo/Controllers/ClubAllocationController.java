package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.ClubAllocation;
import com.example.demo.Repository.ClubRepository;

import com.example.demo.Services.ClubService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/club")
@CrossOrigin(origins="http://localhost:3000")
public class ClubAllocationController {
	@Autowired
	ClubService clubService;
	@Autowired
	ClubRepository clubRepo;
	@Operation(summary = "Creates a new Club")
	@ApiResponses(value = 
{
		@ApiResponse(responseCode = "201",description="Project created sucessfull"),
		@ApiResponse(responseCode = "401", description="Projectprojectid is Invalprojectid"),
		@ApiResponse(responseCode = "404", description="Projectprojectid Not Found")
})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(produces = "application/json", consumes="application/json")
	public ResponseEntity<ClubAllocation> create(final @RequestBody ClubAllocation club){
		ClubAllocation locked = clubService.create(club);
		return ResponseEntity.ok(locked);
	}
	
	public ClubAllocationController(ClubRepository clubRepo) {
		this.clubRepo = clubRepo;
	}
	@Operation(summary = "Get the Project by given projectid")
	@GetMapping(value = "/{clubcode}", produces = "application/json")
	
	public List<ClubAllocation> clubrooms(@PathVariable String clubcode){
		return clubRepo.findByroomcode(clubcode);
	}
	@GetMapping(value = "/user/{username}", produces = "application/json")
	
	public List<ClubAllocation> userclubrooms(@PathVariable String username){
		return clubRepo.findByUsername(username);
	}
     
}
