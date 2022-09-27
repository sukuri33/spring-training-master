package com.beanscopedemoapp.service;

import com.beanscopedemoapp.model.Comment;
import com.beanscopedemoapp.proxy.CommentNotificationProxy;
import com.beanscopedemoapp.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)//By default, spring uses Singleton, meaning you don't have to call out this annotation - this is just to demo the difference between two types of bean management
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)//Uncomment this annotation and run the app see the differences. this would let spring to create new bean each time unlike singleton create once only
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
