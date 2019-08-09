package com.trilogyed.stwitter.viewmodel;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class StwitterViewModel {
    @NotNull(message = "Comment must be valid")
    private Comment comment;
    @NotNull(message = "Post must be valid")
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
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StwitterViewModel svm = (StwitterViewModel) o;
        return  Objects.equals(post, svm.post) &&
                Objects.equals(comment, svm.comment);

    }

    @Override
    public int hashCode() {
        return Objects.hash(post, comment);
    }


}
