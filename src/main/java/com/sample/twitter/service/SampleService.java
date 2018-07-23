package com.sample.twitter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.sample.twitter.model.User;

@Service
public class SampleService {
	
	private List<User> friendList1 = Arrays.asList(
			new User(1, "Sagar", "sagar"),
			new User(2, "Chirag", "chiru"),
			new User(3, "Kiran", "kirs"),
			new User(4, "Arathi", "arathi"),
			new User(5, "Sandeep", "sandy")
			);
	
	private List<User> friendList2 = Arrays.asList(
			new User(1, "Arathi", "arathi"),
			new User(2, "Chirag", "chiru"),
			new User(3, "Sumanth", "sums"),
			new User(4, "Sagar", "sagar"),
			new User(5, "Akash", "aka")
			);

	public List<String> getFriends1(String name) {
		List<String> friendList = new ArrayList<String>();
		boolean nameExist = false;

		for (User user : friendList1) {
			friendList.add(user.getName());
			if (user.getName().equalsIgnoreCase(name)) {
				nameExist = true;
			}
		}
		if (!nameExist) {
			friendList.clear();
		}
		return friendList;
	}
	
	public List<String> getFriends2(String name) {
		List<String> friendList = new ArrayList<String>();
		boolean nameExist = false;

		for (User user : friendList2) {
			friendList.add(user.getName());
			if (user.getName().equalsIgnoreCase(name)) {
				nameExist = true;
			}
		}
		if (!nameExist) {
			friendList.clear();
		}
		return friendList;
	}
	
	public List<String> getMutualFriends(List<String> friendList1, List<String> friendList2) {
		friendList1.retainAll(friendList2);
		
		return friendList1;
	}
}
