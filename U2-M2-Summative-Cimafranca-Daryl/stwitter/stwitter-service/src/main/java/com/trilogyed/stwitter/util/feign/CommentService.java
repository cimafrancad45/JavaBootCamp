package com.trilogyed.stwitter.util.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "comment-service")
public interface CommentService {
}
