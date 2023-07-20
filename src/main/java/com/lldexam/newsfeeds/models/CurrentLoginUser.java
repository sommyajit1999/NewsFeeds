package com.lldexam.newsfeeds.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
public class CurrentLoginUser extends BaseClass{
    @OneToOne
    private User currentUser;
    @CurrentTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
}
