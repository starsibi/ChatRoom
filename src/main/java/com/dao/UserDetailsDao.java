package com.dao;

import java.util.List;

import com.model.UserDetails;

public interface UserDetailsDao {
	
	public void add(UserDetails userdetails);
	public void update(UserDetails userdetails );
	public UserDetails getUserDetailsById(int id);
	public List getAllUserDetails();
	public void delete(int id);
	public void deletealluser();

}
