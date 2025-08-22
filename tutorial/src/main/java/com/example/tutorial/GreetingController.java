package com.example.tutorial;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		if (name.length() > 100 || !name.matches("^[a-zA-Z0-9 ]*$")) {
			throw new IllegalArgumentException("Invalid name parameter");
		}
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
