package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
@RefreshScope
public class CommentController {
    @Autowired
    private CommentDao commentDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        return commentDao.addComment(comment);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable("id") int id){
        if (commentDao.getComment(id) == null)
            //placeholder exception handling
            return null;
        return commentDao.getComment(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments(){
        if (commentDao.getAllComments().size() == 0)
            return null;
        return commentDao.getAllComments();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("id") int id, @RequestBody Comment comment){
        if (comment.getCommentId() == 0)
        comment.setCommentId(id);
        commentDao.updateComment(comment);
        if(id!=comment.getCommentId())
            throw new IllegalArgumentException("Comment ID does not match with comment!");
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id){
        commentDao.deleteComment(id);
    }
}
