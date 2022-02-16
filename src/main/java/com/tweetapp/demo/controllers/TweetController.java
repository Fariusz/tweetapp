package com.tweetapp.demo.controllers;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.services.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    @GetMapping("/tweet")
    public List<Tweet> getTweets() {
       return tweetService.getTweets();
    }

    @PostMapping("/tweet")
    public Tweet addTweet(@RequestBody Tweet tweet, Principal principal){
        return tweetService.addTweet(tweet, principal.getName());
    }

}
