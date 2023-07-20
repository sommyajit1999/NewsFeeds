package com.lldexam.newsfeeds.CommandLine;

import com.lldexam.newsfeeds.Controllers.FeedController;
import com.lldexam.newsfeeds.DTO.FeedRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FeedCommandPattern implements CommandLineMethods{
    FeedController feedController;
    FeedRequestDto feedRequestDto;
    @Autowired
    public FeedCommandPattern(FeedController feedController,FeedRequestDto feedRequestDto){
        this.feedController=feedController;
        this.feedRequestDto=feedRequestDto;

    }
    @Override
    public boolean matches(String input) {
        List<String> list= List.of(input.split(" "));
        return list.size()>1 && list.get(0).equalsIgnoreCase(KeyWordRegister.FEED);
    }

    @Override
    public void execute(String input) {
        String parts[] = input.split(" ", 2);
        feedRequestDto.setText(parts[1]);
        feedController.executeFeed(feedRequestDto);
        return;





    }
}
