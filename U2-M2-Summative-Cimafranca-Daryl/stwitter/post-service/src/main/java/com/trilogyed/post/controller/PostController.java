package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostDao postDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return postDao.createPost(post);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable("id") int id) {
        if (postDao.getPost(id) == null)
            //exception placeholder
            return null;
        return postDao.getPost(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {
        if (postDao.getAllPosts().size() == 0)
            //exception handler placeholder
            return null;
        return postDao.getAllPosts();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        post.setPostId(id);
        postDao.updatePost(post);
        if(id!=post.getPostId())
            throw new IllegalArgumentException("Post ID does not match with post!");

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);

    }
}
