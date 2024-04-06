package com.mentorme.Services;

import java.util.List;

import com.mentorme.Modals.Post;

public interface PostService {
	
	 Post createNewPost(Post post,Integer userid) throws Exception;
	
	 String deletePost(Integer postId , Integer userId ) throws Exception;
	
	 List<Post> findPostsByUserId(Integer Userid);
	 
	Post findPostById(Integer postId) throws Exception;
	
	List<Post>findAllPosts();
	
	Post savedPost(Integer postId , Integer UserId) throws Exception;
	
	Post LikePost(Integer postId,Integer UserId ) throws Exception;
	
	
	

}
