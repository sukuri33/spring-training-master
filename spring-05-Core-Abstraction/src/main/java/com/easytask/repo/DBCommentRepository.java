package com.easytask.repo;

import com.easytask.model.Comment;

public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment content \""+comment.getText()+"\" into database.");
    }
}
