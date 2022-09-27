package com.easytask;

import com.easytask.config.CommentConfig;
import com.easytask.model.Comment;
import com.easytask.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EasyTaskApp
{
    public static void main(String[] args) {

        //Below data would normally come from UI as an input from the end user - since we don't have UI yet
        Comment comment = new Comment();
        comment.setAuthor("James");
        comment.setText("Completed the task");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
