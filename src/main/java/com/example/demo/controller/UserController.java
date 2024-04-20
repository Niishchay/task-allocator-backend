package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.entity.UserAddOn;
import com.example.demo.enums.UserStatus;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("signup")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		return ResponseEntity.ok(userService.createUser(user));
	}
	
	@PostMapping("login")
	public ResponseEntity<User> authenticateUser(@Valid @RequestBody User user) {
		return ResponseEntity.ok(userService.authenticateUser(user));
	}
	
	@GetMapping("lead")
	public ResponseEntity<List<UserAddOn>> getLeadUsers(@RequestParam Long userId) {
		return ResponseEntity.ok(userService.getLeadUsers(userId));
	}
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PutMapping("update-status/{id}")
	public ResponseEntity<User> updateStatus(@PathVariable Long id, @Valid @RequestParam UserStatus status) {
		return ResponseEntity.ok(userService.updateStatus(id, status));
	}
	
}
