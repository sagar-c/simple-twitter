package com.sample.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.twitter.model.User;
import com.sample.twitter.service.SampleService;

@Controller
@RequestMapping(value="/sampleForm")
public class SampleController {
	
	@Autowired
	private SampleService sampleService;

	@RequestMapping(value="/sample", method=RequestMethod.POST)
	public String getFriendsSample(@RequestParam String accountName1, @RequestParam String accountName2, ModelMap modelMap) {
		
		List<User> friendList1 = sampleService.getFriends1(accountName1);
		List<User> friendList2 = sampleService.getFriends2(accountName2);
		
		if (friendList1.isEmpty() && friendList2.isEmpty()) {
			modelMap.put("errorMessage", "Unable to fetch details, please try after some time !!");
		}
		
		List<String> mutualfriendList = sampleService.getMutualFriends(friendList1, friendList2);
		
		if (mutualfriendList.size() == 0) {
			modelMap.put("friendList", "No mutual friends found !!");
		} else {
			modelMap.put("friendList", mutualfriendList);
		}
	   return "sample";
	}
}
