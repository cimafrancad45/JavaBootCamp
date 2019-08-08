package com.trilogyed.post.model;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private int postId;
    private LocalDate postDate;
    private String posterName;
    private String post;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post p = (Post) o;
        return postId == p.postId &&
                        Objects.equals(postDate, p.postDate) &&
                        Objects.equals(posterName, p.posterName) &&
                        Objects.equals(post, p.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, posterName, post);
    }
}
