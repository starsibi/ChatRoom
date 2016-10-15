package com.dao;

import java.util.List;

import com.model.Forum;

public interface ForumDao {

	public void add(Forum forum);
	public void update(Forum forum );
	public List getForumById(int id);
	public List getAllForum();
	public void delete(int id);
	public void deleteAllForum();
}
