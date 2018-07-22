package com.sample.twitter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.twitter.service.TwitterService;

import twitter4j.TwitterException;
import twitter4j.User;

@Controller
@RequestMapping(value="/twitterForm")
public class TwitterController {
	
	@Autowired
	private TwitterService twitterService;

	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String getFriendsTwitter(@RequestParam String accountName1, @RequestParam String accountName2, ModelMap modelMap) {
		
		List<User> friendList1 = new ArrayList<User>();
		List<User> friendList2 = new ArrayList<User>();
		try {
			friendList1 = twitterService.getFriends(accountName1);
			friendList2 = twitterService.getFriends(accountName2);
		} catch (TwitterException twitterException) {
			twitterException.printStackTrace();
			System.out.println("Failed to show friendship: " + twitterException.getMessage());
			
			modelMap.put("errorMessage", "Unable to fetch details, please try after some time !!");
		}
		
		List<String> mutualfriendList = twitterService.getMutualFriends(friendList1, friendList2);
		
		modelMap.put("friendList", mutualfriendList);
		
	   return "index";
	}
}