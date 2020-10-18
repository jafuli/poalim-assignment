package com.example.hapoalim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fib")
@CrossOrigin(origins = "http://localhost:4200")
public class IFibonacciController {

	@Autowired
	private IFibonacciRepository fr;

	@GetMapping("{index}")
	public ResponseEntity<?> fibonacciNumberByIndex(@PathVariable int index) {
		try {
			return ResponseEntity.ok(fr.getByIndex(index));
		} catch (invalidInputException e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
