package com.mentorme.Services;

import java.util.List;

import com.mentorme.Modals.User;

public interface UserService {
		
		public User registerUser(User user);
		
		public User findUserById(Integer id) throws Exception;
		
		public User  findUserByEmail(String Email );
		
		public User followUser(Integer Userid1 , Integer Userid2) throws Exception;
		
		public User updateUser(User user , Integer userId) throws Exception;
		
		public List<User> searchUser(String Query);
}
