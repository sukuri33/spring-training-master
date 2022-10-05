package com.springbootdemoapp.service;

import com.springbootdemoapp.config.AppConfigData;
import com.springbootdemoapp.config.DBConfigData;
import com.springbootdemoapp.model.Comment;
import com.springbootdemoapp.proxy.CommentNotificationProxy;
import com.springbootdemoapp.repo.CommentRepository;
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
    //If there are more than one instance available for an injection point
    //then use @Qualifier annotation to resolve an ambiguity for Spring
    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){

        //Save the comment in to DB
        commentRepository.storeComment(comment);
        //send email notification once a comment is published
        commentNotificationProxy.sendComment(comment);
    }

    public void printConfigData(){
        System.out.println(appConfigData.getUserName());
        System.out.println(appConfigData.getPassWord());
        System.out.println(appConfigData.getUrl());
    }

    public void printDBConfigData(){
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }

}
