package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PostDaoJdbcImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    //prepared statements
    private final String CREATE_POST =
            "insert into post (post_date, poster_name, post) values = (?,?,?)";

    private final String GET_POST_SQL =
            "select * from post where post_id = ?";

    private final String GET_ALL_POSTS_SQL =
            "select * from post";

    public PostDaoJdbcImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Post createPost(Post post){
            jdbcTemplate.update(CREATE_POST,
                    post.getPostDate(),
                    post.getPosterName(),
                    post.getPost());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        post.setPostID(id);

        return post;
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostID(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
}
