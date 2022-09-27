package com.easytask.service;

import com.easytask.model.Comment;
import com.easytask.proxy.CommentNotificationProxy;
import com.easytask.repo.CommentRepository;

public class CommentService {

    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment){

        //Save the comment in to DB
        commentRepository.storeComment(comment);
        //send email notification once a comment is published
        commentNotificationProxy.sendComment(comment);
    }


}
