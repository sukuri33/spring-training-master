package com.springbootdemoapp.proxy;

import com.springbootdemoapp.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class PushCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment" +comment.getText());
    }
}
