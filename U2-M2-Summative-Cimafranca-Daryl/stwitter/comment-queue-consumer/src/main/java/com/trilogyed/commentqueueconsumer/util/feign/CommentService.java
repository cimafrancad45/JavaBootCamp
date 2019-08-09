package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.message.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comment-service")
public interface CommentService {
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public void getComments();

    @RequestMapping(value = "comments/{postId}")
    public void getCommentsByPost(@PathVariable("postId") int postId);

}
