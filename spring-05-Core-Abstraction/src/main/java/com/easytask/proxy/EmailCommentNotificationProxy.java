package com.easytask.proxy;

import com.easytask.model.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment published by: "+comment.getAuthor());
    }
}
