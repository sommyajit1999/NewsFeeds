package com.lldexam.newsfeeds.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseClass{

    private String userName;
    private String password;
    @ManyToMany
    private List<User> followers;
    @ManyToMany
    private List<User> following;
    @OneToMany
    private List<Feeds> feeds;

}
