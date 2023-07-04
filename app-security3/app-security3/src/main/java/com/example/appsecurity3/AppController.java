package com.example.appsecurity3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("hello")     //sales
	public String hello()
	{
		System.out.println("from hello");
		return "from hello";
	}
	
	@GetMapping("test")          // marketing
	public String test()
	{
		System.out.println("from test");
		return "from test";
	}
}
