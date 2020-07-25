package com.inter.api.technicalTest.controller;

import org.springframework.http.ResponseEntity;

public interface IUserController {
	
	public ResponseEntity<String> calculatesSingleDigit(String n);
	
	public ResponseEntity<String> findAll();
	
	public ResponseEntity<String> findById(String id);
	
	public ResponseEntity<String> create();
	
	public ResponseEntity<String> update(String id);
}
