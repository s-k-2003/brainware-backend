package com.example.demo.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Projectdata;
import com.example.demo.Services.ProjectServices;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins="http://localhost:3000")

public class ProjectController {
	@Autowired
	ProjectServices projectservices;
	
	//CREATION
	
		@Operation(summary = "Creates a new Project")
		
		
		@ApiResponses(value = 
	{
			@ApiResponse(responseCode = "201",description="Project created sucessfull"),
			@ApiResponse(responseCode = "401", description="Projectprojectid is Invalprojectid"),
			@ApiResponse(responseCode = "404", description="Projectprojectid Not Found")
	})
		
		
		@ResponseStatus(HttpStatus.CREATED)
		
		@PostMapping(produces = "application/json", consumes="application/json")

		public ResponseEntity<Projectdata> create(final @RequestBody Projectdata details){
			Projectdata project = projectservices.create(details);
			return ResponseEntity.ok(project);
		}
		
		
		//SELECTION
		
		@Operation(summary = "Get the Project by given projectid")
		@GetMapping(value = "/{id}", produces = "application/json")
		
		
		
		
		public ResponseEntity<Optional<Projectdata>> read(final @PathVariable("id") Long id){
			Optional<Projectdata> createdProject = projectservices.read(id);
			return ResponseEntity.ok(createdProject);
		}
		
		//Updating
		
			@Operation(summary = "Update the Project by given projectid")

			@ApiResponses(value = {
					@ApiResponse(responseCode = "200",description = "Project updated successfully"),
					@ApiResponse(responseCode = "400",description = "Projectprojectid is invalprojectid"),
					@ApiResponse(responseCode = "401",description = "Invalprojectid Credentials"),
					@ApiResponse(responseCode = "404",description = "Project Not Found")
				})


			
			@PutMapping(value = "/{projectid}", produces="application/json")
			public ResponseEntity<Projectdata> update(final @RequestBody Projectdata details) throws JsonProcessingException{
				final Projectdata updatedprojectid = projectservices.update(details);
				return ResponseEntity.ok(updatedprojectid);
			}
			
			
			//Deletion
			
			@Operation(summary = "Delete the Project by projectid")
			
			
			@ApiResponses(value = {
					
					@ApiResponse(responseCode = "200",description = "Project deleted successfully"),
					@ApiResponse(responseCode = "400",description = "Projectprojectid is invalprojectid"),
					@ApiResponse(responseCode = "401",description = "Invalprojectid Credentials"),
					@ApiResponse(responseCode = "404",description = "Project Not Found")
					
			})
			
			@DeleteMapping(value = "/{id}")
			
			public void delete(final @PathVariable Long id) {
				projectservices.delete(id);
			}
}
