package com.lldexam.newsfeeds.CommandLine;

import com.lldexam.newsfeeds.Controllers.FeedController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowMyFeedCommandPattern implements CommandLineMethods{
    FeedController feedController;
    @Autowired
    public ShowMyFeedCommandPattern(FeedController feedController){
        this.feedController=feedController;
    }
    @Override
    public boolean matches(String input) {
        List<String> list= List.of(input.split(" "));
        return list.get(0).equalsIgnoreCase(KeyWordRegister.SHOWFEED);
    }

    @Override
    public void execute(String input) {
        feedController.showmyfeed();

    }
}
