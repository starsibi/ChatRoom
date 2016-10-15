package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ForumDao;
import com.model.Forum;
@Service
public class ForumServiceImpl implements ForumService{
	@Autowired
	ForumDao forumdao;
	
	@Transactional
	public void add(Forum forum) {
		forumdao.add(forum);
	}

	@Transactional
	public void update(Forum forum) {
		forumdao.update(forum);
		
	}

	@Transactional
	public List getForumById(int id) {
		
		return forumdao.getForumById(id);
	}

	@Transactional
	public List getAllForum() {
		
		return forumdao.getAllForum();
	}

	@Transactional
	public void delete(int id) {
		forumdao.delete(id);
		
	}

	@Transactional
	public void deleteAllForum() {
		forumdao.getAllForum();
		
	}

}
