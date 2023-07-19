package com.lldexam.newsfeeds.DTO;

import com.lldexam.newsfeeds.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    User user;
     public SignUpResponseDto(User user){
        this.user=user;
         if(user==null)
         {
             System.out.println("INVALID TRY AGAIN");
         }
         else {
             System.out.println("User SignUp Successfull");
         }
    }



}
