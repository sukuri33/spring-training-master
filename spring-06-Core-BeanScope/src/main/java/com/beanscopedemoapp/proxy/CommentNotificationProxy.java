package com.beanscopedemoapp.proxy;

import com.beanscopedemoapp.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
