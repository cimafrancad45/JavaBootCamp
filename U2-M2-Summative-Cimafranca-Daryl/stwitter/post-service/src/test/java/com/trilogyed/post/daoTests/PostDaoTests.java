package com.trilogyed.post.daoTests;


import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoTests {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp(){
        List<Post> pList = postDao.getAllPosts();
        for (Post p : pList){
            postDao.deletePost(p.getPostId());
        }
    }

    @Test
    public void getAddDeletePost(){
        Post post = new Post();
        post.setPostDate(LocalDate.parse("2019-08-07"));
        post.setPosterName("@Miku39");
        post.setPost("Magical Mirai starts in a month! Will you be going?");

        post = postDao.createPost(post);

        Post post1 = postDao.getPost(post.getPostId());

        assertEquals(post1, post);

        postDao.deletePost(post.getPostId());

        post1 = postDao.getPost(post.getPostId());

        assertNull(post1);

    }

    @Test
    public void updatePost(){
        Post post = new Post();
        post.setPostDate(LocalDate.parse("2019-08-07"));
        post.setPosterName("@Miku39");
        post.setPost("Magical Mirai starts in a month! Will you be going?");

        post = postDao.createPost(post);

        post.setPostDate(LocalDate.parse("2019-08-09"));
        post.setPosterName("@Miku39");
        post.setPost("Magical Mirai starts soon! Will you be going?");

        postDao.updatePost(post);

        Post post1 = postDao.getPost(post.getPostId());

        assertEquals(post1, post);


    }

    @Test
    public void getAllPosts(){
        Post post = new Post();
        post.setPostDate(LocalDate.parse("2019-08-07"));
        post.setPosterName("@Miku39");
        post.setPost("Magical Mirai starts in a month! Will you be going?");

        postDao.createPost(post);

        Post post1 = new Post();
        post1.setPostDate(LocalDate.parse("2019-09-03"));
        post1.setPosterName("@Miku39");
        post1.setPost("Magical Mirai is happening right now!");

        postDao.createPost(post1);

        List<Post> pList = postDao.getAllPosts();

        assertEquals(pList.size(), 2);


    }
    


}
