package com.lldexam.newsfeeds.Service;

import com.lldexam.newsfeeds.Repo.CurrentUserRepo;
import com.lldexam.newsfeeds.Repo.FeedRepository;
import com.lldexam.newsfeeds.Repo.UserRepository;
import com.lldexam.newsfeeds.models.CurrentLoginUser;
import com.lldexam.newsfeeds.models.Feeds;
import com.lldexam.newsfeeds.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedService {
    FeedRepository feedRepository;
    CurrentUserRepo currentUserRepo;
    UserRepository userRepository;
    @Autowired
    public FeedService(FeedRepository feedRepository,CurrentUserRepo currentUserRepo,UserRepository userRepository){
        this.feedRepository=feedRepository;
        this.currentUserRepo=currentUserRepo;
        this.userRepository=userRepository;
    }
    public Feeds getFeed(String feeds){
        System.out.println(feeds);
        CurrentLoginUser currentLoginUser=currentUserRepo.findTopByOrderByIdDesc();
        Feeds feed=new Feeds();
        feed.setFeedText(feeds);
        feed.setDownVotes(0);
        feed.setUpVotes(0);
        feed.setUser(currentLoginUser.getCurrentUser());
        Optional<User> user=userRepository.findById(currentLoginUser.getCurrentUser().getId());
        if(user.isEmpty()){
            System.out.println("No Current User..Kindly Login");
            return null;
        }
        List<Feeds> feedss =new ArrayList<>();
        feedss.add(feed);
        User updatefeedUser=user.get();
        feed.setUser(updatefeedUser);
        updatefeedUser.setFeeds(feedss);
        Feeds f=feedRepository.save(feed);
        User u=userRepository.save(updatefeedUser);
        return f;
    }
}
