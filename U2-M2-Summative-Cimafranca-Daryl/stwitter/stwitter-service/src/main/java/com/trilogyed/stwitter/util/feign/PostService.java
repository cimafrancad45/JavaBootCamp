package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostService {

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(Post post);

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public Post getPost(int id);

    @RequestMapping(value = "/posts/{userName}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("userName") String userName);





}
