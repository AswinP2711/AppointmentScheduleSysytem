package com.ass.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello...";
	}
}
