package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Forum {
	@Id
	private int forum_id;
	private String forum_name;
	private int posted_time;
	private int posted_date;
	private String comment_id;
	private String forumApproved;
	private int Rating_id;
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_name() {
		return forum_name;
	}
	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}
	public int getPosted_time() {
		return posted_time;
	}
	public void setPosted_time(int posted_time) {
		this.posted_time = posted_time;
	}
	public int getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(int posted_date) {
		this.posted_date = posted_date;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getForumApproved() {
		return forumApproved;
	}
	public void setForumApproved(String forumApproved) {
		this.forumApproved = forumApproved;
	}
	public int getRating_id() {
		return Rating_id;
	}
	public void setRating_id(int rating_id) {
		Rating_id = rating_id;
	}
	

}
