package com.lldexam.newsfeeds.Controllers;

import com.lldexam.newsfeeds.DTO.FeedRequestDto;
import com.lldexam.newsfeeds.DTO.FeedResponseDto;
import com.lldexam.newsfeeds.Service.FeedService;
import com.lldexam.newsfeeds.models.Feeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedController {
    FeedService feedService;
    @Autowired
    public FeedController(FeedService feedService){
        this.feedService=feedService;
    }
    public FeedResponseDto executeFeed(FeedRequestDto feedRequestDto){
        String feed=feedRequestDto.getText();
        Feeds f=feedService.getFeed(feed);
        return new FeedResponseDto(f);

    }

}
