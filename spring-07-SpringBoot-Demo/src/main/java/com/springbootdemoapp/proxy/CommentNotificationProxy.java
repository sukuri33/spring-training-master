package com.springbootdemoapp.proxy;

import com.springbootdemoapp.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
