package com.lldexam.newsfeeds.Service;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import com.lldexam.newsfeeds.Repo.CurrentUserRepo;
import com.lldexam.newsfeeds.Repo.FeedRepository;
import com.lldexam.newsfeeds.Repo.UserRepository;
import com.lldexam.newsfeeds.models.CurrentLoginUser;
import com.lldexam.newsfeeds.models.Feeds;
import com.lldexam.newsfeeds.models.User;
import com.lldexam.newsfeeds.showFeedStrategy.UpVotesShowFeedStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class FeedService {
    FeedRepository feedRepository;
    CurrentUserRepo currentUserRepo;
    UserRepository userRepository;
    UpVotesShowFeedStrategy upVotesShowFeedStrategy;
    Scanner sc;
    @Autowired
    public FeedService(FeedRepository feedRepository,CurrentUserRepo currentUserRepo,UserRepository userRepository,UpVotesShowFeedStrategy upVotesShowFeedStrategy){
        this.feedRepository=feedRepository;
        this.currentUserRepo=currentUserRepo;
        this.userRepository=userRepository;
        this.upVotesShowFeedStrategy=upVotesShowFeedStrategy;
        sc=new Scanner(System.in);
    }
    public Feeds getFeed(String feeds){
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
    public List<Feeds> showMyFeeds(){
        CurrentLoginUser currentLoginUser=currentUserRepo.findTopByOrderByIdDesc();
        Optional<List<Feeds>> feedsList=feedRepository.findAllByUserId(currentLoginUser.getCurrentUser().getId());
        if(feedsList.isEmpty()){
            System.out.println("NO FEEDS FOUND");
            return null;
        }
        System.out.println("My Feeds:");

        return showMyFeeds(upVotesShowFeedStrategy.showFeeds(feedsList));
    }
    public List<Feeds> showMyFeeds(List<Feeds> feedsListss){
        int i=0;
        while (true){
            if(i==feedsListss.size()){
                System.out.println("No More Feeds!");
                break;
            }
            System.out.println(feedsListss.get(i).getFeedText()+ "  " + feedsListss.get(i).getDownVotes()+" DV"+" "+feedsListss.get(i).getUpVotes()+" UV"+ " "+feedsListss.get(i).getUser().getUserName()+" "+feedsListss.get(i).getTimeStamp());
            System.out.println("Press: 1->Next Feed; 2->Upvote this feed; 3->DownVote this feed; 4->Back");
            int input=sc.nextInt();
            if(input==1)
            {
                i++;
                continue;
            }
            else if(input==2){
                feedsListss.get(i).setUpVotes(feedsListss.get(i).getUpVotes()+1);
                feedRepository.save(feedsListss.get(i));
                continue;
            }
            else if(input==3){
                feedsListss.get(i).setDownVotes(feedsListss.get(i).getDownVotes()+1);
                feedRepository.save(feedsListss.get(i));
                continue;
            }
            else {
                break;
            }

        }
        return feedsListss;
    }

}
