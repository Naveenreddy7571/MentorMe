package com.mentorme.config;

import java.time.LocalDate;
import java.util.Date;

import javax.crypto.SecretKey;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.cglib.core.Local;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {

		private SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEYString.getBytes());
		
		public String generateToken(Authentication auth)
		{
			String jwt = Jwts.builder().
					setIssuer("naveenthecoder").setIssuedAt(new Date().getTime()+86400000)).

					Claim("email",auth.getName()).
		}
}
