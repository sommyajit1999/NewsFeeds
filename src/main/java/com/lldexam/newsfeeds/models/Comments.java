package com.lldexam.newsfeeds.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;
@Getter
@Setter
@Entity
public class Comments extends BaseClass{
    private String Comment;
    private int upVotes;
    private int downVotes;
    @CurrentTimestamp
    @Temporal(TemporalType.TIME)
    private Date timeStamp;
    @ManyToOne
    private User user;
    @ManyToOne
    private Feeds feeds;


}
