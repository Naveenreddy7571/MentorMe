package com.mentorme.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mentorme.Modals.User;
import com.mentorme.Repositores.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userrepository;
	

	@Override
	public User registerUser(User user) {
		User registeredUser = userrepository.save(user);
		return registeredUser;
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		Optional<User> user = userrepository.findById(id);
		
		if(user.isPresent())
		{
			return user.get();
		}
		else {
			throw new Exception("user doesnot exists with the userid "+id); 
		}
	}

	@Override
	public User findUserByEmail(String Email) {
		User user = userrepository.findByEmail(Email);
		return user;
	}

	@Override
	public User followUser(Integer followingid, Integer followeeid) throws Exception {
		User user1 = findUserById(followingid);
		User user2 = findUserById(followeeid);
		user2.getFollowers().add(followingid);
		user1.getFollowings().add(followeeid);
	    User updateduser1 = userrepository.save(user1);
	    userrepository.save(user2);
	    return updateduser1;
	    
	}

	@Override
	public User updateUser(User user , Integer userId)  throws Exception{
		Optional<User> oldUser =userrepository. findById(userId);
		if(!oldUser.isPresent())
		{
			throw new Exception("User doest not Exist by id "+userId);
		}
		
		User old=oldUser.get();
		if(user.getFirstName() != null)
		{
			old.setFirstName(user.getFirstName());
		}
		
		if(user.getLastName() != null)
		{
			old.setLastName(user.getLastName());
		}
		
		if(user.getEmail() != null)
		{
			old.setEmail(user.getEmail());
		}
		
		if(user.getGender() != null)
		{
			old.setGender(user.getGender());
		}
		
		if(user.getFirstName() != null)
		{
			old.setFirstName(user.getFirstName());
		}
		
		if(user.getEmail() != null)
		{
			old.setYear(user.getYear());
		}
		
		if(user.getInterestedDomain() != null)
		{
			old.setInterestedDomain(user.getInterestedDomain());
		}
		
		return userrepository.save(old);
	}

	@Override
	public List<User> searchUser(String Query) {
		
		return userrepository.searchUser(Query);
	}

	public String deleteUser(Integer id) {
		
		try {
			userrepository.deleteById(id);
		} 
		catch (Exception  e) {
			return "Error Occured";
			
		}
		return "Deleted Sucess";
		
		
	}

	public List<User> getAllUsers() {
		return userrepository.findAll();
	}

}
