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

	public List<User> getFriends1(String name) {
		
		List<User> friendList = new ArrayList<User>();
		boolean nameExist = false;
		
		while (friendList1.iterator().hasNext()) {
			if (friendList1.iterator().next().getName().equalsIgnoreCase(name)) {
				nameExist = true;
			}
			break;
		}
		
		if (nameExist) {
			friendList.addAll(friendList1);
		}
		return friendList;
	}
	
	public List<User> getFriends2(String name) {
		List<User> friendList = new ArrayList<User>();
		boolean nameExist = false;
		
		while (friendList2.iterator().hasNext()) {
			if (friendList2.iterator().next().getName().equalsIgnoreCase(name)) {
				nameExist = true;
			}
			break;
		}
		
		if (nameExist) {
			friendList.addAll(friendList2);
		}
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
