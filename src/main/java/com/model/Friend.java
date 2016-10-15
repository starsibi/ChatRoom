package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Friend {
	@Id
	private int id;
	private String UserId;
	private String FriendId;
	private  String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getFriendId() {
		return FriendId;
	}
	public void setFriendId(String friendId) {
		FriendId = friendId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
