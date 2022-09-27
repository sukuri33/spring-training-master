package com.beanscopedemoapp;

import com.beanscopedemoapp.config.CommentConfig;
import com.beanscopedemoapp.model.Comment;
import com.beanscopedemoapp.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("James");
        comment.setText("Completed the task");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);

        System.out.println(cs1);
        System.out.println(cs2);
        System.out.println(cs1 == cs2);

    }
}
