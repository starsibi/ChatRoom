package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Blog;

@Repository
public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	//save the blogdata in database 
	@Override
	public void add(Blog blog) {
		sessionfactory.getCurrentSession().save(blog);
		
	}
	
	//update the blog data in database
	@Override
	public void update(Blog blog) {
		sessionfactory.getCurrentSession().update(blog);
		
	}

	//get the blog data by blogid
	@Override
	public List getBlogById(int id) {
		return sessionfactory.getCurrentSession().createQuery("from Blog where blog_id='"+id+"'").list();
	}

	//get all the blog data from the blog table
	@Override
	public List getAllBlog() {
		
		return sessionfactory.getCurrentSession().createQuery("from Blog").list();
	}

	//delete the blog data based on blog id
	@Override
	public void delete(int id) {
	sessionfactory.getCurrentSession().delete(getBlogById(id));
		
	}

	@Override
	public void deleteAllBlog() {
		sessionfactory.getCurrentSession().clear();
		
	}

}
