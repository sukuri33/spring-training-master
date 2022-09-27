package com.easytask.proxy;

import com.easytask.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment published by: "+comment.getAuthor());
    }
}
