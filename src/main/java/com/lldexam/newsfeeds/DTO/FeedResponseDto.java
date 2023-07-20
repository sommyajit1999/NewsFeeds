package com.lldexam.newsfeeds.DTO;

import com.lldexam.newsfeeds.models.Feeds;
import org.springframework.stereotype.Component;


public class FeedResponseDto {
    Feeds feeds;
    public FeedResponseDto(Feeds feeds)
    {
        this.feeds=feeds;
        if(feeds==null)
        {
            System.out.println("No Feed");
            return ;
        }
    }
}
