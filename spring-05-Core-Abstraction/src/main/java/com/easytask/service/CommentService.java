package com.easytask.service;

import com.easytask.model.Comment;
import com.easytask.proxy.CommentNotificationProxy;
import com.easytask.repo.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentService {
    //#1 Scenario: by good practice 'final' keyword is recommended so that you wouldn't forget to create constructor
    //#2 Scenario: sometimes you declare field and forgot to add them in the constructor argument, if you have a habit of using final keyword it would help you avoid such mistake
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment){

        //Save the comment in to DB
        commentRepository.storeComment(comment);
        //send email notification once a comment is published
        commentNotificationProxy.sendComment(comment);
    }


}
