package com.lldexam.newsfeeds.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    @CurrentTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date LoginTime;
    @CurrentTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date CreatedTime;

}
