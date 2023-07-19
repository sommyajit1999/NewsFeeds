package com.lldexam.newsfeeds.CommandLine;

import com.lldexam.newsfeeds.Controllers.UserController;
import com.lldexam.newsfeeds.DTO.LoginRequestDto;
import com.lldexam.newsfeeds.DTO.SignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LoginCommandPattern implements CommandLineMethods {
    UserController userController;
    LoginRequestDto loginRequestDto;
    @Autowired
    public LoginCommandPattern( UserController userController, LoginRequestDto loginRequestDto){
        this.userController=userController;
        this.loginRequestDto=loginRequestDto;
    }
    @Override
    public boolean matches(String input) {
        List<String> list= List.of(input.split(" "));
        return list.size() == 3 && list.get(0).equalsIgnoreCase(KeyWordRegister.LOGIN);
    }

    @Override
    public void execute(String input) {
        List<String> list= List.of(input.split(" "));
        String name=list.get(1);
        String password=list.get(2);
        loginRequestDto.setUserName(name);
        loginRequestDto.setPassword(password);
        userController.LoginUser(loginRequestDto);

    }
}
