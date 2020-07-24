package com.inter.api.technicalTest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inter.api.technicalTest.model.User;
import com.inter.api.technicalTest.service.IUserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	static final Logger log = LoggerFactory.getLogger(UserController.class);
			
	@Autowired
	IUserService userService;

	@GetMapping(path = "/{id}/singleDigit")
	public ResponseEntity<Integer> calculatesSingleDigit(@PathVariable("id") Long userId, @RequestParam("n") String n,
			@RequestParam("k") Integer k) {
		try {
			return ResponseEntity.ok(userService.calculatesSingleDigit(userId, n, k));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll() {
		try {
			return ResponseEntity.ok(userService.findAll());
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		try {

			return ResponseEntity.ok(userService.findById(id).orElse(null));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody User user) {
		try {
			// TODO mudar para DTO
			userService.create(user);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			userService.update(id, user);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			userService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
