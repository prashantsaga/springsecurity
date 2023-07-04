package com.example.appsecurity2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppSecurity2Application implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AppSecurity2Application.class, args);
		System.out.println("from app-security2");
	}
	@Override
	public void run(String... args) throws Exception {
		Person p1 = new Person();
		p1.setUserName("vijay@gmail.com");
		p1.setPassword(encoder.encode("123"));
		p1.setRole("ROLE_SOFTWARE");
		personRepository.save(p1);
		
		Person p2 = new Person();
		p2.setUserName("swetha@gmail.com");
		p2.setPassword(encoder.encode("abc"));
		p2.setRole("ROLE_HR");
		personRepository.save(p2);
		
		
	}
}
