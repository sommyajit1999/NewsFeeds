package com.lldexam.newsfeeds.DTO;

import com.lldexam.newsfeeds.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter

public class LoginResponseDto {
    User user;

    public LoginResponseDto (User user)
    {
        this.user=user;
        if(user==null)
        {
            System.out.println("Try Again!");
            return;
        }
        System.out.println("Login Successfull: "+user.getUserName());
    }
}
