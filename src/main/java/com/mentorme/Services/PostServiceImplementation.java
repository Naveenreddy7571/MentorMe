package com.mentorme.Services;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mentorme.Modals.Post;
import com.mentorme.Modals.User;
import com.mentorme.Repositores.PostRepository;
import com.mentorme.Repositores.UserRepository;

@Service
public class PostServiceImplementation implements PostService {
	@Autowired
	PostRepository postRepository;
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@Autowired
	UserRepository userepo;
	@Override
	public Post createNewPost(Post post, Integer userId) throws Exception {
	    User user = userServiceImplementation.findUserById(userId);
	    if (user == null) {
	        throw new Exception("User not found with ID: " + userId);
	    }
	    post.setUser(user);
	    post.setCreatedTime(LocalDateTime.now()); 
	    Post newPost = postRepository.save(post);
	    return newPost;
	}


	@Override
	public String deletePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostById(postId);
		User user = userServiceImplementation.findUserById(userId);
		if(post.getUser().getUserId() != user.getUserId())
		{
			throw new Exception("You cannot delete another user post");
		}
		postRepository.delete(post);
		return "postDeletedSuccessfully";		
	}

	@Override
	public List<Post> findPostsByUserId(Integer userId) {
		return postRepository.findPostsByUserId(userId);
	}

	@Override
	public Post findPostById(Integer postId) throws Exception {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isEmpty())
		{
			throw new Exception("No Post Found by this PostId"+postId);
		}
		
		return  post.get();
	}

	@Override
	public List<Post> findAllPosts() {
		
		return postRepository.findAll();
	}

	@Override
	public Post savedPost(Integer postId, Integer UserId) throws Exception {
		Post post = findPostById(postId);
		User user = userServiceImplementation.findUserById(UserId);
		
		if(user.getSavedPosts().contains(post))
		{
			user.getSavedPosts().remove(post);
		}
		else {
			user.getSavedPosts().add(post);
		}
		
		 userepo.save(user);
		return post;
	}

	@Override
	public Post LikePost(Integer postId, Integer UserId) throws Exception {
		Post post = findPostById(postId);
		User user = userServiceImplementation.findUserById(UserId);
		if(post.getLiked().contains(user))
		{
			post.getLiked().remove(user);
		}
		else {
			post.getLiked().add(user);
		}
		
		return postRepository.save(post);
	}
	

}
