package com.example.demo.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			User registerUSer = userService.userRegister(user);
			return ResponseEntity.ok(Map.of("message","UserRegister SuccessFully", "User", registerUSer));
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(Map.of("Error",e.getMessage()));
		}
	}

}
