package com.lldexam.newsfeeds.DTO;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class LoginRequestDto {
    private String userName;
    private String password;
}
