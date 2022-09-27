package com.beanscopedemoapp.repo;

import com.beanscopedemoapp.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
