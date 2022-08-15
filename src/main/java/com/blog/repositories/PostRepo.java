package com.blog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	Page<Post> findByUser(User user, Pageable page);
	
	Page<Post> findByCategory(Category cat, Pageable page);
	
	List<Post> findByTitleContaining(String title);
	
	/*
	 * alternative
	 * 
	 * 	@Query("select p from Post p where p.title like :key")
	 *  List<Post> findByTitleContaining(@Param("key") String title);
	 */
}
