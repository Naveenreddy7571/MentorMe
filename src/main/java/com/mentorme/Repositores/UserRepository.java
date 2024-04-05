package com.mentorme.Repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mentorme.Modals.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.firstName) LIKE %:query% OR LOWER(u.lastName) LIKE %:query% OR LOWER(u.email) LIKE %:query% OR LOWER(u.interestedDomain) LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);

}
