package com.bptn.feedApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .headers(headers -> headers.frameOptions(frame -> frame.disable()))
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/user/signup", "/h2-console/**").permitAll()
	            .anyRequest().authenticated()
	        )
	        .httpBasic(withDefaults());

	    return http.build();
	}
}
