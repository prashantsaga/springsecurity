 package com.example.securityapp1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class AppSecurityConfiguration {
	
	@Bean
	public UserDetailsService getUser(BCryptPasswordEncoder encoder)
	{
		InMemoryUserDetailsManager userManager = new InMemoryUserDetailsManager();
		userManager.createUser(User
								.withUsername("Akash")
								.password(encoder.encode("Akash@123"))
								.roles("ADMIN")
								.build());
		userManager.createUser(User
								.withUsername("Swati")
								.password(encoder.encode("Swati@123"))
								.roles("EMP")
								.build());
		userManager.createUser(User
				.withUsername("Ravi")
				.password(encoder.encode("Ravi@123"))
				.roles("ADMIN", "EMP")
				.build());
		return userManager;
	}
	@Bean
	public SecurityFilterChain authorization(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests()
		.requestMatchers("/").permitAll()
		.requestMatchers("/hello").hasRole("EMP")
		.requestMatchers("/test").hasAnyRole("EMP", "ADMIN")
		.and()
		.httpBasic();
		return http.build();
	}
	
	
	@Bean
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
