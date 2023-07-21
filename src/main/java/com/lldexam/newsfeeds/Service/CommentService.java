package com.lldexam.newsfeeds.Service;

import com.lldexam.newsfeeds.Repo.CommentRepo;
import com.lldexam.newsfeeds.models.Comments;
import com.lldexam.newsfeeds.models.Feeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CommentService {
    CommentRepo commentRepo;
    Scanner sc;
    @Autowired
    public CommentService(CommentRepo commentRepo){
        this.commentRepo=commentRepo;
        sc=new Scanner(System.in);
    }
    public Comments saveComment(Feeds feed)
    {
        System.out.println("Enter your Comment:");
        String commment=sc.nextLine();
        Comments comments=new Comments();
        comments.setComment(commment);
        comments.setUser(feed.getUser());
        comments.setUpVotes(0);
        comments.setDownVotes(0);
        comments.setFeeds(feed);
        return commentRepo.save(comments);
    }
    public void getComments(Feeds feed){
        Optional<List<Comments>> comments=commentRepo.findAllByFeeds(feed);
        if(comments.isEmpty()){
            System.out.println("No Comments on this post");
            return;
        }
        for(Comments comments1:comments.get()){
            System.out.println(comments1.getComment());
        }
        return;
    }

}
