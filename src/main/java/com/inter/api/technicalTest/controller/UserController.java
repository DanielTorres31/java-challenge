package com.inter.api.technicalTest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.inter.api.technicalTest.commons.Response;
import com.inter.api.technicalTest.model.Calculation;
import com.inter.api.technicalTest.model.User;
import com.inter.api.technicalTest.service.IUserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	static final Logger log = LoggerFactory.getLogger(UserController.class);
			
	@Autowired
	IUserService userService;

	@GetMapping(path = "/{id}/singleDigit")
	public ResponseEntity<Response<Calculation>> calculatesSingleDigit(@PathVariable("id") Long userId, @RequestParam("n") String n, @RequestParam("k") Integer k) {
		try {
			Calculation calculation = userService.calculatesSingleDigit(userId, n, k);
			return ResponseEntity.ok(new Response<Calculation>(HttpStatus.OK.value(), calculation));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response<Calculation>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<User>>> findAll() {
		try {
			List<User> users = userService.findAll();
			return ResponseEntity.ok(new Response<List<User>>(HttpStatus.OK.value(), users));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<User>> findById(@PathVariable("id") Long id) {
		try {
			User user = userService.findById(id).orElse(null);
			return ResponseEntity.ok(new Response<>(HttpStatus.OK.value(), user));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response<User>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<User>> create(@RequestBody User user) {
		try {
			User createdUser = userService.create(user);
			return ResponseEntity.ok(new Response<>(HttpStatus.OK.value(), createdUser));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response<User>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<Response<User>> update(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			User updatedUser = userService.update(id, user);
			return ResponseEntity.ok(new Response<>(HttpStatus.OK.value(), updatedUser));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response<User>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<User>> delete(@PathVariable("id") Long id) {
		try {
			userService.delete(id);
			return ResponseEntity.ok(new Response<>(HttpStatus.OK.value()));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response<User>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
}
