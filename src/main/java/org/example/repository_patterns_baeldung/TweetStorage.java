package org.example.repository_patterns_baeldung;

import java.util.ArrayList;
import java.util.List;

public class TweetStorage implements TweetInterface{

    private final List<TweetModel> tweets = new ArrayList<>();

    @Override
    public void add(TweetModel tweet) {
        tweets.add(tweet);
    }

    @Override
    public List<TweetModel> find(String email) {
        List<TweetModel> foundTweets = new ArrayList<>();

        for (TweetModel tweet:tweets) {
            if (tweet.email.equals(email)) {
                foundTweets.add(tweet);
            }
        }

        if (foundTweets.size()==0)
          System.out.println("Tweet not found, email:"+email);

        return foundTweets;
    }
}
