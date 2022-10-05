package com.springbootdemoapp.repo;

import com.springbootdemoapp.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
