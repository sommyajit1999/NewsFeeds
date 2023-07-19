package com.lldexam.newsfeeds.CommandLine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommandLineCheck{
    List<CommandLineMethods> commands;
    @Autowired
    public CommandLineCheck(SignUpCommandPattern signUpCommandPattern,
                            LoginCommandPattern loginCommandPattern){
        commands=new ArrayList<>();
        commands.add(signUpCommandPattern);
        commands.add(loginCommandPattern);
    }
    public void executeCommand(String input){
        for(CommandLineMethods commands:commands){
            if(commands.matches(input)){
                commands.execute(input);
            }
        }
    }

}
