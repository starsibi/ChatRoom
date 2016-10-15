package com.service;

import java.util.List;

import com.model.UserDetails;

public interface UserDetailsService {
	public void add(UserDetails userdetails);
	public void update(UserDetails userdetails );
	public UserDetails getUserDetailsById(int id);
	public List getAllUserDetails();
	public void delete(int id);
	public void deleteallusers();


}
