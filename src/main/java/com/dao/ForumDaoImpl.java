package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Forum;

@Repository
public class ForumDaoImpl implements ForumDao{
	@Autowired
	SessionFactory sessionfactory;
	
	//save the forum data in database
	@Override
	public void add(Forum forum) {
		sessionfactory.getCurrentSession().save(forum);
	}

	//update  the forum data in database
	@Override
	public void update(Forum forum) {
		sessionfactory.getCurrentSession().update(forum);
		
	}

	//get the forum  data from database based on forumid
	@Override
	public List getForumById(int id) {
		
		return sessionfactory.getCurrentSession().createQuery("from Forum where forum_id ='"+id+"'").list();
	}

	//get all the forum data from the forum table
	@Override
	public List getAllForum() {
		
		return sessionfactory.getCurrentSession().createQuery("from Forum").list();
	}

	//delete the forum data from the forum table based on forum id
	@Override
	public void delete(int id) {
		sessionfactory.getCurrentSession().delete(getForumById(id));
		
	}

	@Override
	public void deleteAllForum() {
		sessionfactory.getCurrentSession().clear();
		
	}

}
