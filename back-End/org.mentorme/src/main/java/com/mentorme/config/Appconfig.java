package com.mentorme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Appconfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
			
		http.sessionManagement((session) -> session
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		 http.authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/api/**").authenticated()
	            .anyRequest().permitAll());
	       
		 http.addFilterBefore(new jwtValidator(), BasicAuthenticationFilter.class);
		 
		 http.csrf((csrf) -> csrf.disable() );
	
				
		return http.build();
	}

}
