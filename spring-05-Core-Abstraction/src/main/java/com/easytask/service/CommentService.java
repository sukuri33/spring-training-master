package com.easytask.service;

import com.easytask.model.Comment;
import com.easytask.proxy.CommentNotificationProxy;
import com.easytask.repo.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
    //#1 Scenario: by good practice 'final' keyword is recommended so that you wouldn't forget to create constructor
    //#2 Scenario: sometimes you declare field and forgot to add them in the constructor argument, if you have a habit of using final keyword it would help you avoid such mistake
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
                                                             //this might never be the case in the real world because you will always have one impl class for one interface.
                                                             //but for interview purpose please remember below scenario:
                                                             //in the event that your 2nd implementation class of CommentNotificationProxy interface
                                                             //in this case it is "PushNotificationProxy", is needed for a different Service class
                                                             //And you used @Primary annotation for "EmailCommentNotificationProxy" class to tell Spring avoid using the 2nd impl class
                                                             //then the other Service class would also use EmailProxy class.
                                                             //To address such concern we have @Qualifier annotation in Spring
    public CommentService(CommentRepository commentRepository,@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        //Save the comment in to DB
        commentRepository.storeComment(comment);
        //send email notification once a comment is published
        commentNotificationProxy.sendComment(comment);
    }


}
