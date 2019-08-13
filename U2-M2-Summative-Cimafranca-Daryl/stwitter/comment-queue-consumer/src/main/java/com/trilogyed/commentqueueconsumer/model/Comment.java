package com.trilogyed.commentqueueconsumer.model;

import java.time.LocalDate;
import java.util.Objects;

public class Comment {
    private int commentId;
    private int postId;
    private String commenterName;
    private LocalDate createDate;
    private String comment;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Comment c = (Comment) o;
        return commentId == c.commentId &&
                postId == c.postId &&
                Objects.equals(createDate, c.createDate)&&
                Objects.equals(commenterName, c.commenterName) &&
                Objects.equals(comment, c.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, createDate, commenterName, comment);
    }

}
