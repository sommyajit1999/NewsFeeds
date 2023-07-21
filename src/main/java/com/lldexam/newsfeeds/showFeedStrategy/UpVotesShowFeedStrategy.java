package com.lldexam.newsfeeds.showFeedStrategy;

import com.lldexam.newsfeeds.Repo.FeedRepository;
import com.lldexam.newsfeeds.models.Feeds;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UpVotesShowFeedStrategy implements showFeedsStrategy{
    FeedRepository feedRepository;
    Scanner sc;
    public UpVotesShowFeedStrategy(FeedRepository feedRepository){
        this.feedRepository=feedRepository;
        sc=new Scanner(System.in);
    }
    @Override
    public List<Feeds> showFeeds(Optional<List<Feeds>> feedsList) {
        List<Feeds> feedsListss= feedsList.get();
        Collections.sort(feedsListss,(a, b)->b.getUpVotes()-a.getUpVotes());
        return feedsListss;
    }
}
