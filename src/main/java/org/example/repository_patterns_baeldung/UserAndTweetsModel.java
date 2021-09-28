package org.example.repository_patterns_baeldung;

import java.util.List;

public class UserAndTweetsModel extends UserModel{
    public List<TweetModel> tweets;

    public UserAndTweetsModel(String name, String email) {
        super(name, email);
    }

    public UserAndTweetsModel(UserModel user) {
        super(user.name, user.email);
    }

    @Override
    public String toString() {
        return "UserAndTweetsModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tweets=" + tweets +
                '}';
    }
}
