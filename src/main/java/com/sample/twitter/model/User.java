package com.sample.twitter.model;

public class User {

	private int id;
	private String name;
	private String screenName;

	public User(int id, String name, String screenName) {
		this.id = id;
		this.name = name;
		this.screenName = screenName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
