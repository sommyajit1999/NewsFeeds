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
    @OneToMany
    private List<User> followers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> following;
    @OneToMany(mappedBy = "user")
    private List<Feeds> feeds;

}
