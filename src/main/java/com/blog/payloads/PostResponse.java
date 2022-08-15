package com.blog.payloads;

import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {
	
	private List<PostDto> content;
	private Integer pageNo;
	private Integer pageSize;
	private long totalElements;
	private Integer totalPages;
//	private String sortBy;
	private boolean isLastPage;
}
