package com.tejait.batch15.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="typicode",url = "https://jsonplaceholder.typicode.com/")
public interface TypiFeign {

	@GetMapping("comments")
	public List<CommentsDto> getcomments();
}
