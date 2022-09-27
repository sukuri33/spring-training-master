package com.easytask.repo;

import com.easytask.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment content \""+comment.getText()+"\" into database.");
    }
}
