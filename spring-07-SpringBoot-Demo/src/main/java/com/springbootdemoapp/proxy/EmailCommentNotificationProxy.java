package com.springbootdemoapp.proxy;

import com.springbootdemoapp.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")//customizing class reference name - shortened version
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment published by: "+comment.getAuthor());
    }
}
