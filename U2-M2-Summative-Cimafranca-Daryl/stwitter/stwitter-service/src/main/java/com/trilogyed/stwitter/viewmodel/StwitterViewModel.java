package com.trilogyed.stwitter.viewmodel;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;

public class StwitterViewModel {
    private Comment comment;
    private Post post;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
