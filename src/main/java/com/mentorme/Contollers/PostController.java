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
import org.springframework.web.bind.annotation.RestController;

import com.mentorme.Modals.Post;
import com.mentorme.Services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/createpost/{userId}")
	public Post createNewPost(@RequestBody Post post , @PathVariable("userId") Integer userId) throws Exception
	{
		return postService.createNewPost(post, userId);
	}
	
	@DeleteMapping("/deletepost/{postid}/{userid}")
	public String deletePost(@PathVariable("postid") Integer postid, @PathVariable("userid") Integer userid ) throws Exception
	{
		return postService.deletePost(postid, userid);
	}
	
	@GetMapping("/findpostsusers/{userid}")
	public List<Post>  findPostbyid(@PathVariable("userid") Integer userId)
	{
		return postService.findPostsByUserId(userId);
	}
	
	@GetMapping("/findpostbyid/{postid}")
	public Post findpostbyid(@PathVariable("postid") Integer postid) throws Exception
	{
		return postService.findPostById(postid);
	}
	
	@GetMapping("/allposts")
	public List<Post> findAllPosts()
	{
		return postService.findAllPosts();
	}
	
	@GetMapping("/savepost/{postid}/{userid}")
	public Post savedPost(@PathVariable("postid") Integer postid , @PathVariable("userid") Integer userid) throws Exception
	{
		return postService.savedPost(postid, userid);
	}
	
	@PutMapping("/likepost/{postid}/{userid}")
	public Post likePost(@PathVariable("postid") Integer postid, @PathVariable("userid")Integer userid) throws Exception
	{
		return postService.LikePost(postid, userid);
	}

}
