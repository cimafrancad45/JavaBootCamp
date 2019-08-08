package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcImpl implements PostDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostDaoJdbcImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //prepared statements
    private final String CREATE_POST =
            "insert into post (post_date, poster_name, post) values (?,?,?)";

    private final String GET_POST_SQL =
            "select * from post where post_id = ?";

    private final String GET_ALL_POSTS_SQL =
            "select * from post";

    private final String UPDATE_POST_SQL =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";

    private final String DELETE_POST =
            "delete from post where post_id = ?";


    @Override
    public Post createPost(Post post){
            jdbcTemplate.update(CREATE_POST,
                    post.getPostDate(),
                    post.getPosterName(),
                    post.getPost());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        post.setPostId(id);

        return post;
    }

    @Override
    public Post getPost(int id){
        try {
            return jdbcTemplate.queryForObject(GET_POST_SQL, this::mapRowToPost, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> getAllPosts(){
        return jdbcTemplate.query(GET_ALL_POSTS_SQL, this::mapRowToPost);
    }

    @Override
    public void updatePost(Post post){
        jdbcTemplate.update(UPDATE_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostId());
    }

    @Override
    public void deletePost(int id){
        jdbcTemplate.update(DELETE_POST, id);
    }

    @Transactional
    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
}
