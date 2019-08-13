package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CommentJdbcTemplateImpl implements CommentDao {
    //setting up jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CommentJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //prepared sql statements
    private final String CREATE_COMMENT_SQL =
            "insert into comment (post_id, create_date, commenter_name, comment) values (?,?,?,?)" ;
    private final String GET_COMMENT_SQL =
            "select * from comment where comment_id = ?";
    private final String GET_ALL_COMMENTS_SQL =
            "select * from comment";
    private final String GET_COMMENTS_BY_POST_ID =
            "select * from comment where post_id = ?";
    private final String UPDATE_COMMENT_SQL =
            "update comment set post_id = ?, create_date = ?, commenter_name = ?, comment = ? where comment_id = ?";
    private final String DELETE_COMMENT_SQL =
            "delete from comment where comment_id = ?";

    @Override
    public Comment addComment(Comment comment){
        jdbcTemplate.update(CREATE_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        comment.setCommentId(id);
        return comment;
    }

    @Override
    public Comment getComment(int id){
        try{
            return jdbcTemplate.queryForObject(GET_COMMENT_SQL, this::mapRowToComment, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments(){
        return jdbcTemplate.query(GET_ALL_COMMENTS_SQL, this::mapRowToComment);
    }

    @Override
    public List<Comment> getCommentsByPostId(int id) {
        return jdbcTemplate.query(GET_COMMENTS_BY_POST_ID, this::mapRowToComment, id);
    }

    @Override
    public void updateComment(Comment comment){
        jdbcTemplate.update(UPDATE_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                comment.getCommentId());

    }

    @Override
    public void deleteComment(int id){
        jdbcTemplate.update(DELETE_COMMENT_SQL, id);

    }

    @Transactional
    private Comment mapRowToComment(ResultSet rs, int rowNum) throws SQLException{
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setComment(rs.getString("comment"));

        return comment;
    }
}
