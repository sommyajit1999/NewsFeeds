package com.lldexam.newsfeeds.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Feeds extends BaseClass{
    private String feedText;
    private int upVotes;
    private int downVotes;
    @OneToMany
    private List<Comments> comments;
    @ManyToOne
    private User user;
    @CurrentTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

}
