package org.example.repository_patterns_baeldung;

import java.util.List;

public interface TweetInterface {
    void add (TweetModel tweet);
    List<TweetModel> find(String email);
}
