package org.example.repository_patterns_baeldung;


public class UserAndTweetRepoRunner {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();


        userRepository.add(new UserModel("John", "john@domain.com"));
        userRepository.add(new UserModel("Susan", "susan@domain.com"));

        userRepository.addTweet(new TweetModel("john@domain.com", "Im stupid", "2021.10.21"));

        System.out.println(userRepository.get(0));

        System.out.println(userRepository.findTweetsFromUserWithEmail("john@domain.com"));

        System.out.println(userRepository.findUserAndPersonsTweets("John"));

        System.out.println(userRepository.findUserAndPersonsTweets("Susan"));


    }
}
