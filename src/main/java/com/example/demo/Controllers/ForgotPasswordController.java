package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Login;
import com.example.demo.Models.Register;
import com.example.demo.Services.RegisterServices;
import com.example.demo.Services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/forgotpassword")
@CrossOrigin(origins = "http://localhost:3000")
public class ForgotPasswordController {
    @Autowired
    RegisterServices regservice;
    
    @Autowired
    UserService userService;

    // Updating Register Table
    @Operation(summary = "Updating user password in Register Table")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User password updated Successfully"),
        @ApiResponse(responseCode = "401", description = "Invalid UserName"),
        @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PutMapping(value = "/register/{username}", produces = "application/json")
    public ResponseEntity<?> updateRegister(@PathVariable String username, @RequestBody Register details, BindingResult result) throws JsonProcessingException {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getFieldErrors(result));
        }

        final Register updatedId = regservice.update(details);
        return ResponseEntity.ok(updatedId);
    }

    // Updating Login Table
    @Operation(summary = "Updating user password in Login Table")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User password updated Successfully"),
        @ApiResponse(responseCode = "401", description = "Invalid UserName"),
        @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PutMapping(value = "/login/{username}", produces = "application/json")
    public ResponseEntity<?> updateLogin(@PathVariable String username, @RequestBody Login details, BindingResult result) throws JsonProcessingException {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getFieldErrors(result));
        }

        final Login updatedId = userService.update(details);
        return ResponseEntity.ok(updatedId);
    }

    private String getFieldErrors(BindingResult result) {
        StringBuilder errors = new StringBuilder();
        for (FieldError error : result.getFieldErrors()) {
            errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(", ");
        }
        return errors.substring(0, errors.length() - 2);
    }
}
