package com.inter.api.technicalTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inter.api.technicalTest.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping(path = "/users/singleDigit")
	public ResponseEntity<String> calculatesSingleDigit(@RequestParam("n") String n, @RequestParam("k") Integer k) {
		try {
			Integer response = userService.calculatesSingleDigit(n, k);
			return ResponseEntity.ok("singleDigit: " + response);
		} catch(Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	@GetMapping(path = "/users", produces = { "application/json" })
	public ResponseEntity<String> findAll() {
		return ResponseEntity.ok("findAll");
	}
	
	@GetMapping(path = "/users/{id}", produces = { "application/json" })
	public ResponseEntity<String> findById(@PathVariable("id") String id) {
		return ResponseEntity.ok("findById");
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<String> create() {
		return ResponseEntity.ok("create");
	}
	
	@PutMapping(path = "/users/{id}")
	public ResponseEntity<String> update(@PathVariable("id") String id) {
		return ResponseEntity.ok("update");
	}
}
