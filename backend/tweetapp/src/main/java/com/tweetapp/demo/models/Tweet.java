package com.tweetapp.demo.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "tweet")
public class Tweet {

    @Id
    private String id;
    @Field("created_by")
    @CreatedBy
    private String createdBy;
    @Field("title")
    private String title;
    @Field("content")
    private String content;
    @Field("created")
    @CreatedDate
    private LocalDateTime created;
    @Field("modified")
    @LastModifiedDate
    private LocalDateTime modified;
    @Field("likes")
    @DocumentReference(lazy = true)
    private List<User> likes;
    @Field("is_reply")
    private Boolean isReply;
    @Field("replies")
    @DocumentReference(lazy = true)
    private List<Tweet> replies;
}
