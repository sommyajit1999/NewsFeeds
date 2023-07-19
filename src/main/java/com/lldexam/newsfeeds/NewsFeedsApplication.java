package com.lldexam.newsfeeds;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class NewsFeedsApplication implements CommandLineRunner {
    Scanner sc=new Scanner(System.in);
    @Override
    public void run(String... args) throws Exception {
        while(true){
            System.out.println("Insert your command:");
            String command=sc.nextLine();

        }
    }

    public static void main(String[] args) {
        SpringApplication.run(NewsFeedsApplication.class, args);
    }

}
