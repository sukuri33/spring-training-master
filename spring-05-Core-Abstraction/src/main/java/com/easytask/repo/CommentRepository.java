package com.easytask.repo;

import com.easytask.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
