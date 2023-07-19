package com.lldexam.newsfeeds;

import com.lldexam.newsfeeds.CommandLine.CommandLineCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class NewsFeedsApplication implements CommandLineRunner {
    Scanner sc;
    CommandLineCheck commandLineCheck;
    @Autowired
    public NewsFeedsApplication(CommandLineCheck commandLineCheck){
        this.commandLineCheck=commandLineCheck;
        sc=new Scanner(System.in);
    }
    @Override
    public void run(String... args) throws Exception {
        while(true){
            System.out.println("Insert your command:");
            String command=sc.nextLine();
            commandLineCheck.executeCommand(command);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(NewsFeedsApplication.class, args);
    }

}
