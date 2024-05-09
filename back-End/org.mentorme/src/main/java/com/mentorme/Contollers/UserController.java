package com.mentorme.Contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentorme.Modals.User;
import com.mentorme.Services.UserServiceImplementation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImplementation userService;
	
	
	@GetMapping("/allusers")
	public List<User> getallUsers()
	{
		return userService.getAllUsers();
	}
	@PostMapping("/registeruser")
	public  User registerUser(@RequestBody User user)
	{
		return userService.registerUser(user);
	}
	
	@GetMapping("/finduserbyid/{id}")
	public User findUserById(@PathVariable Integer id) throws Exception
	{
		return userService.findUserById(id);
	}
	
	@GetMapping("/finduserbyemail/{email}")
	public User findUserByEmail(@PathVariable String email)
	{
		return userService.findUserByEmail(email);
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody  User user , @PathVariable Integer id) throws Exception
	{
		return userService.updateUser(user, id);
	}
	
	@PutMapping("/followuser/{followerid}/{followeeid}")
	public User followuser(@PathVariable Integer followerid , @PathVariable Integer followeeid) throws Exception
	{
		return userService.followUser(followerid, followeeid);
	}
	@GetMapping("/searchuser")
	public List<User> SearchUser(@RequestParam("query") String  query)
	{
		query=query.trim();
			return userService.searchUser(query);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable Integer id)
	{
		return userService.deleteUser(id);
	}
}
