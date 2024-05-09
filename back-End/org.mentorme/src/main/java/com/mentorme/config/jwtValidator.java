package com.mentorme.config;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtValidator extends OncePerRequestFilter {

	public static String jWT_HEADER="Authorization";
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
			String jwt = request.getHeader(JwtConstant.jWT_HEADER);
			if(jwt!=null)
			{
				try {
					
				} catch (e) {
					// TODO: handle exception
				}
			}
		
			
		
	}


}
