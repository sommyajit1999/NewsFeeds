package com.lldexam.newsfeeds.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SignUpRequestDto {
    private String userName;
    private String password;
}
