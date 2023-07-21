package com.lldexam.newsfeeds.Controllers;

import com.lldexam.newsfeeds.Service.CommentService;
import com.lldexam.newsfeeds.models.Feeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
@Controller
public class CommentController {
    CommentService commentService;
    Scanner sc;
    @Autowired
    public CommentController(CommentService commentService){
        this.commentService=commentService;
        sc=new Scanner(System.in);
    }
    public void commentFunc(Feeds feeds){
        System.out.println("Press: 1: to see comments, 2: write comments");
        int input=sc.nextInt();
        if(input==1){
            commentService.getComments(feeds);
        }
        else if(input==2){
            commentService.saveComment(feeds);
        }
        else{
            return;
        }
    }

}
