package com.ltm.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltm.ecommerce.dto.LoginRequest;
import com.ltm.ecommerce.dto.LoginResponse;
import com.ltm.ecommerce.dto.UserRequest;
import com.ltm.ecommerce.dto.UserResponse;
import com.ltm.ecommerce.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	private final  UserService userService;
	
	public UserController (UserService userService) {
		this.userService=userService;
	}
	
	 @PostMapping("/register")
	    public ResponseEntity<UserResponse> registerUser(
	            @Valid @RequestBody UserRequest request) {

	        UserResponse response = userService.registerUser(request);

	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }
	 
	 @PostMapping("/login")
	 public ResponseEntity<LoginResponse> login(
	         @Valid @RequestBody LoginRequest request) {

	     LoginResponse response = userService.login(request);

	     return ResponseEntity.ok(response);
	 }
}
