package com.easytask.proxy;

import com.easytask.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
