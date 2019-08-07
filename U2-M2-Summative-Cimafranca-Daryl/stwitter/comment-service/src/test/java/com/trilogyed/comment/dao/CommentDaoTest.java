package com.trilogyed.comment.dao;


import com.trilogyed.comment.model.Comment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp(){
        List<Comment> cList = commentDao.getAllComments();

        for (Comment c : cList){
            commentDao.deleteComment(c.getCommentId());
        }
    }

    @Test
    public void getAddDeleteComment(){

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCommenterName("@Mr_Ryu45");
        comment.setCreateDate(LocalDate.parse("2019-09-12"));
        comment.setComment("Wow, that was sick!");

        comment = commentDao.addComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment1, comment);

        commentDao.deleteComment(comment.getCommentId());

        comment1 = commentDao.getComment(comment.getCommentId());

        assertNull(comment1);


    }

    @Test
    public void updateComment(){
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCommenterName("@Mr_Ryu45");
        comment.setCreateDate(LocalDate.parse("2019-09-12"));
        comment.setComment("Wow, that was sick!");

        comment = commentDao.addComment(comment);


        comment.setPostId(1);
        comment.setCommenterName("@Lotus_Prince");
        comment.setCreateDate(LocalDate.parse("2019-10-11"));
        comment.setComment("We sure made a lot of progress today!");

        commentDao.updateComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment1, comment);

    }

    @Test
    public void getAllComments(){
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCommenterName("@Mr_Ryu45");
        comment.setCreateDate(LocalDate.parse("2019-09-12"));
        comment.setComment("Wow, that was sick!");

        Comment comment1 = new Comment();
        comment1.setPostId(2);
        comment1.setCommenterName("@Lotus_Prince");
        comment1.setCreateDate(LocalDate.parse("2019-10-11"));
        comment1.setComment("We sure made a lot of progress today!");

        commentDao.addComment(comment);
        commentDao.addComment(comment1);

        List<Comment> cList = new ArrayList<>();

        cList.add(comment);
        cList.add(comment);

        List<Comment> cList1 = commentDao.getAllComments();

        assertEquals(cList.size(), cList1.size());



    }

}
