package org.example.repository_patterns_baeldung;

import java.util.Date;

public class TweetModel {
    public String email;
    public String tweetText;
    public String dateCreated;

    public TweetModel(String email, String tweetText, String dateCreated) {
        this.email = email;
        this.tweetText = tweetText;
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "TweetModel{" +
                "email='" + email + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
