package org.example.repository_patterns_baeldung;

import java.util.List;

public class UserRepository implements UserRepositoryInterface{

    private UserStorage userStorage;
    private TweetStorage tweetStorage;

    public UserRepository() {
        this.userStorage = new UserStorage();
        this.tweetStorage = new TweetStorage();
    }

    public UserStorage getUserStorage() {
        return userStorage;
    }

    public TweetStorage getTweetStorage() {
        return tweetStorage;
    }

    @Override
    public UserModel get(int id) {
        //UserAndTweetsModel user=(UserAndTweetsModel) userStorage.read(id);
        //user.tweets=tweetStorage.find(user.email);

        UserModel user=userStorage.read(id);
        return user;
    }

    @Override
    public void add(UserModel user) {
        userStorage.create(user);
    }

    @Override
    public void remove(UserModel user) {
        userStorage.delete(user.name);
    }

    public void addTweet(TweetModel tweet) {
        tweetStorage.add(tweet);
    }

    public List<TweetModel> findTweetsFromUserWithEmail(String email) {
        return tweetStorage.find(email);
    }

    public UserAndTweetsModel findUserAndPersonsTweets(String name) {
        UserModel user=getUserStorage().findUser(name);
        UserAndTweetsModel userAndTweet=new UserAndTweetsModel(user);
        userAndTweet.tweets=findTweetsFromUserWithEmail(user.email);
        return userAndTweet;
    }

}
