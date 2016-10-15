package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BlogDao;
import com.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogDao blogdao;
	
	@Transactional
	public void add(Blog blog) {
		blogdao.add(blog);
		
	}

	@Transactional
	public void update(Blog blog) {
		blogdao.update(blog);
		
	}

	@Transactional
	public List getBlogById(int id) {
		
		return blogdao.getBlogById(id);
	}

	@Transactional
	public List getAllBlog() {
		
		return blogdao.getAllBlog();
	}

	@Transactional
	public void delete(int id) {
		blogdao.delete(id);
		
	}

	@Transactional
	public void deleteAllBlog() {
		blogdao.getAllBlog();
		
	}
	

}
