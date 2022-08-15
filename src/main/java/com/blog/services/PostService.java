package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {
	
	// create
	PostDto createPost(PostDto postDto, Integer userId, Integer catId);
	
	// update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	// get all posts
	PostResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy);
		
	// get single post by Id
	PostDto getPostById(Integer postId);
	
	// get all post by category
	PostResponse getPostsByCategory(Integer catId, Integer pageNo, Integer pageSize, String sortBy);
	
	// get all post by user
	PostResponse getPostsByUser(Integer userId, Integer pageNo, Integer pageSize, String sortBy);
	
	// get searched posts
	List<PostDto> searchPosts(String keyword);
}
