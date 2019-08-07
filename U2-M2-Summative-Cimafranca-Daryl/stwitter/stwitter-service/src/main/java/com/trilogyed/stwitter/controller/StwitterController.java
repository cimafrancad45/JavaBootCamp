package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class StwitterController {



    ServiceLayer service;

    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    @PostMapping
    public Post createPost(@RequestBody @Valid Post post){
        return null;
    }

    @GetMapping(value = "{id}")
    public Post getPost(@RequestParam("id") int id){
        return null;
    }

    @GetMapping(value = "/user/{poster_name}")
    public List<Post> getPostsByUser(@RequestParam("poster_name") String poster){
        return null;
    }


}
