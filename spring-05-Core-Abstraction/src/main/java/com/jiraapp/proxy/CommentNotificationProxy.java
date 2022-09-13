package com.jiraapp.proxy;

import com.jiraapp.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}