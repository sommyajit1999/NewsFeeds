package com.lldexam.newsfeeds.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class BaseClass {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    Date LoginTime;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    Date CreatedTime;

}
