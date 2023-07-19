package com.lldexam.newsfeeds.Controllers;

import com.lldexam.newsfeeds.DTO.LoginRequestDto;
import com.lldexam.newsfeeds.DTO.LoginResponseDto;
import com.lldexam.newsfeeds.DTO.SignUpRequestDto;
import com.lldexam.newsfeeds.DTO.SignUpResponseDto;
import com.lldexam.newsfeeds.Service.UserService;
import com.lldexam.newsfeeds.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    public SignUpResponseDto SignUpUser(SignUpRequestDto signUpRequestDto){

        String name=signUpRequestDto.getUserName();
        String password=signUpRequestDto.getPassword();
        User user =userService.SignUpUser(name,password);
        return new SignUpResponseDto(user);
    }
    public LoginResponseDto LoginUser(LoginRequestDto loginRequestDto){
        String name=loginRequestDto.getUserName();
        String password=loginRequestDto.getPassword();
        User user =userService.LoginUser(name,password);
        return new LoginResponseDto(user);

    }
}
