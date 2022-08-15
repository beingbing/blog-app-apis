package com.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.repositories.CategoryRepo;
import com.blog.repositories.PostRepo;
import com.blog.repositories.UserRepo;
import com.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer catId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ", "User Id", userId));
		Category category = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", catId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("https://sunreal.co/application/modules/themes/views/default/assets/images/1.jpg");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", "Post Id ", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", "Post Id ", postId));
		this.postRepo.delete(post);
		
	}

	@Override
	public PostResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		Page<Post> postsPage = this.postRepo.findAll(page);
		List<Post> posts = postsPage.getContent();
		List<PostDto> postDtoList = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtoList);
		postResponse.setPageNo(postsPage.getNumber());
		postResponse.setPageSize(postsPage.getSize());
//		postResponse.setSortBy(postsPage.getSort());
		postResponse.setTotalElements(postsPage.getTotalElements());
		postResponse.setTotalPages(postsPage.getTotalPages());
		postResponse.setLastPage(postsPage.isLast());
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", "Post Id ", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostResponse getPostsByCategory(Integer catId, Integer pageNo, Integer pageSize, String sortBy) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		Category category = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", catId));
		Page<Post> postsPage = this.postRepo.findByCategory(category, page);
		List<Post> posts = postsPage.getContent();
		List<PostDto> postDtoList = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtoList);
		postResponse.setPageNo(postsPage.getNumber());
		postResponse.setPageSize(postsPage.getSize());
//		postResponse.setSortBy(postsPage.getSort());
		postResponse.setTotalElements(postsPage.getTotalElements());
		postResponse.setTotalPages(postsPage.getTotalPages());
		postResponse.setLastPage(postsPage.isLast());
		return postResponse;
	}

	@Override
	public PostResponse getPostsByUser(Integer userId, Integer pageNo, Integer pageSize, String sortBy) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ", "User Id", userId));
		Page<Post> postsPage = this.postRepo.findByUser(user, page);
		List<Post> posts = postsPage.getContent();
		List<PostDto> postDtoList = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtoList);
		postResponse.setPageNo(postsPage.getNumber());
		postResponse.setPageSize(postsPage.getSize());
//		postResponse.setSortBy(postsPage.getSort());
		postResponse.setTotalElements(postsPage.getTotalElements());
		postResponse.setTotalPages(postsPage.getTotalPages());
		postResponse.setLastPage(postsPage.isLast());
		return postResponse;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
