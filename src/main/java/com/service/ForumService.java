package com.service;

import java.util.List;

import com.model.Forum;

public interface ForumService {

	public void add(Forum forum);
	public void update(Forum forum );
	public List getForumById(int id);
	public List getAllForum();
	public void delete(int id);
	public  void deleteAllForum();
}
