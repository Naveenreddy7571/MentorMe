package com.mentorme.Modals;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private int year;
	private String interestedDomain;

	private List<Integer> followings = new ArrayList<>();
	private List<Integer> followers = new ArrayList<>();

	@ManyToMany
	private List<Post> savedPosts = new ArrayList<>();

	// Getters and setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getInterestedDomain() {
		return interestedDomain;
	}

	public void setInterestedDomain(String interestedDomain) {
		this.interestedDomain = interestedDomain;
	}

	public List<Integer> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Integer> followings) {
		this.followings = followings;
	}

	public List<Integer> getFollowers() {
		return this.followers;
	}

	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}

	public List<Post> getSavedPosts() {
		return savedPosts;
	}

	public void setSavedPosts(List<Post> savedPosts) {
		this.savedPosts = savedPosts;
	}

}
