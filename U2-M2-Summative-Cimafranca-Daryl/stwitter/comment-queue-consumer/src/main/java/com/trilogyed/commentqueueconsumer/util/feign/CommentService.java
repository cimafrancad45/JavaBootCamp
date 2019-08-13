package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comment-service")
public interface CommentService {
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public void getComments();

    @RequestMapping(value = "/comment/{postId}", method = RequestMethod.GET)
    public void getCommentsByPost(@PathVariable("postId") int postId);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") int id);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    public void updateComment(@PathVariable("id") int id, @RequestBody Comment comment)

}
