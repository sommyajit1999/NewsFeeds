package com.lldexam.newsfeeds.CommandLine;

import com.lldexam.newsfeeds.Controllers.UserController;
import com.lldexam.newsfeeds.DTO.FollowRequestDto;
import com.lldexam.newsfeeds.DTO.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FollowCommandPattern implements CommandLineMethods{

    UserController userController;
    FollowRequestDto followRequestDto;
    @Autowired
    public FollowCommandPattern(FollowRequestDto followRequestDto,UserController userController){
        this.followRequestDto=followRequestDto;
        this.userController=userController;
    }
    @Override
    public boolean matches(String input) {
        List<String> list= List.of(input.split(" "));
        return list.size() == 2 && list.get(0).equalsIgnoreCase(KeyWordRegister.FOLLOW);
    }

    @Override
    public void execute(String input) {
        List<String> list= List.of(input.split(" "));
        String name=list.get(1);
        followRequestDto.setName(name);
        userController.followUser(followRequestDto);


    }
}
