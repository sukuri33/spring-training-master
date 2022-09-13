package com.jiraapp.repository;

import com.jiraapp.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}