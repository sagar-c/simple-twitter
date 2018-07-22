package com.sample.twitter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

@Service
public class TwitterService {
	
	@Value("${consumerKey}")
	String consumerKey;
	@Value("${consumerSecret}")
	String consumerSecret;
	@Value("${accessToken}")
	String accessToken;
	@Value("${accessSecret}")
	String accessSecret;

	public List<User> getFriends(String name) throws TwitterException {
		
		PagableResponseList<User> responseList = null;
		List<User> friendList = new ArrayList<User>();

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(accessToken, accessSecret));
		long cursor = -1;
			   
		do {
			responseList = twitter.getFriendsList(name, cursor); 
			
			responseList.forEach(user->{
				friendList.add(user);
			});
		} while ((cursor = responseList.getNextCursor()) != 0);
		return friendList;
	}
	
	public List<String> getMutualFriends(List<User> friendList1, List<User> friendList2) {
		List<String> mutualFriendList = new ArrayList<String>();
		
		friendList1.forEach(user1->{
			friendList2.forEach(user2->{
				if (user1.getName().equals(user2.getName())) {
					mutualFriendList.add(user1.getName());
				}
			});
		});
		
		return mutualFriendList;
	}
}
