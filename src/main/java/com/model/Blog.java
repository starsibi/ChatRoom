package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blog_id;
	private String blog_name;
	private Date posted_time;
	private Date posted_date;
	private boolean blog_approved;
	private String img_name;
	
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getBlog_name() {
		return blog_name;
	}
	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}
	public Date getPosted_time() {
		return posted_time;
	}
	public void setPosted_time(Date posted_time) {
		this.posted_time = posted_time;
	}
	public Date getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(Date posted_date) {
		this.posted_date = posted_date;
	}
	public boolean isBlog_approved() {
		return blog_approved;
	}
	public void setBlog_approved(boolean blog_approved) {
		this.blog_approved = blog_approved;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	
}
