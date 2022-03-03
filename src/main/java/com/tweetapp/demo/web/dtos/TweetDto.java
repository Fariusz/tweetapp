package com.tweetapp.demo.web.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TweetDto {
    private String id;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime created;
}
