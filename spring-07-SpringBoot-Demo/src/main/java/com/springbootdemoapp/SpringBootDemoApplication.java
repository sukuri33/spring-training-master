package com.springbootdemoapp;

import com.springbootdemoapp.model.Comment;
import com.springbootdemoapp.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {


		Comment comment = new Comment();
		comment.setAuthor("James");
		comment.setText("Completed the task");

		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		CommentService commentService = context.getBean(CommentService.class);
		commentService.publishComment(comment);
		commentService.printConfigData();
		commentService.printDBConfigData();
	}


}
