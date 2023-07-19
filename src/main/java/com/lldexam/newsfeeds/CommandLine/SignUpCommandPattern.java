package com.lldexam.newsfeeds.CommandLine;

import com.lldexam.newsfeeds.Controllers.UserController;
import com.lldexam.newsfeeds.DTO.SignUpRequestDto;
import com.lldexam.newsfeeds.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SignUpCommandPattern implements CommandLineMethods {
    UserController userController;
    SignUpRequestDto signUpRequestDto;
    @Autowired
    public SignUpCommandPattern(UserController userController,SignUpRequestDto signUpRequestDto){
        this.userController=userController;
        this.signUpRequestDto=signUpRequestDto;
    }
    @Override
    public boolean matches(String input) {
        List<String> list= List.of(input.split(" "));
        return list.size() == 4 && list.get(0).equalsIgnoreCase(KeyWordRegister.SIGNUP);
    }

    @Override
    public void execute(String input) {
        List<String> list= List.of(input.split(" "));
        String name=list.get(1);
        String password=list.get(2);
        signUpRequestDto.setUserName(name);
        signUpRequestDto.setPassword(password);
        userController.SignUpUser(signUpRequestDto);
    }
}
