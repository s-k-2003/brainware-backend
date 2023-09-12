package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Login;
import com.example.demo.Services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/logindata")
@CrossOrigin

public class LoginController {
	@Autowired
    UserService userService;

   
@Operation(summary = "Login new user")
	@ApiResponses(value = 
{
	@ApiResponse(responseCode = "200", description="User LoggedIn Successfully"),
	@ApiResponse(responseCode = "401", description="Invalid User"),
	@ApiResponse(responseCode = "404", description ="Not Found")
			
})
	@ResponseStatus(HttpStatus.CREATED)



  
   @PostMapping(produces = "application/json", consumes="application/json")
   public ResponseEntity<Login> create(final @RequestBody Login details){
   	Login category = userService.create(details);
		return ResponseEntity.ok(category);
   }

   @PostMapping("/auth")
   public String login(@RequestBody UserLoginRequest loginRequest) {
	   String username = loginRequest.getUsername();
	   String pasword = loginRequest.getPasword();
	   boolean isValidUser = userService.isValidUser(username, pasword);
	   if(isValidUser) {
		   return "Login Successful";
	   }else {
		   return "Invalid username or Password";
	   }
   }
   
   static class UserLoginRequest{
	   private String username;
	   public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	private String pasword;
   }
   

}
