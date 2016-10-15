package com.dao;

import java.util.List;

import com.model.Blog;

public interface BlogDao {
	
	public void add(Blog blog);
	public void update(Blog blog );
	public List getBlogById(int id);
	public List getAllBlog();
	public void delete(int id);
	public void deleteAllBlog();

}
