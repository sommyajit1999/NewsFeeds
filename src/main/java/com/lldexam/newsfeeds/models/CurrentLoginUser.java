package com.lldexam.newsfeeds.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CurrentLoginUser extends BaseClass{
    @OneToOne
    private User currentUser;
}
