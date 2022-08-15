package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;

public interface PostService {
	
	// create
	PostDto createPost(PostDto postDto, Integer userId, Integer catId);
	
	// update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	// get all posts
	List<PostDto> getAllPosts(Integer pageNo, Integer pageSize, String sortBy);
		
	// get single post by Id
	PostDto getPostById(Integer postId);
	
	// get all post by category
	List<PostDto> getPostsByCategory(Integer catId);
	
	// get all post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	// get searched posts
	List<PostDto> searchPosts(String keyword);
}
