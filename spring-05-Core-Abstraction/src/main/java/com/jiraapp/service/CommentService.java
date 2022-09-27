package com.jiraapp.service;

import com.jiraapp.model.Comment;
import com.jiraapp.proxy.CommentNotificationProxy;
import com.jiraapp.proxy.EmailCommentNotificationProxy;
import com.jiraapp.repository.CommentRepository;
import com.jiraapp.repository.DBCommentRepository;

public class CommentService {

    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}