package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDetailsDao;
import com.model.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDetailsDao userdetailsdao;
	
	@Transactional
	public void add(UserDetails userdetails) {
		userdetailsdao.add(userdetails);
		
	}

	@Transactional
	public void update(UserDetails userdetails) {
		userdetailsdao.update(userdetails);
		
	}

	@Transactional
	public UserDetails getUserDetailsById(int id) {
		
		return userdetailsdao.getUserDetailsById(id);
	}

	@Transactional
	public List getAllUserDetails() {
		
		return userdetailsdao.getAllUserDetails();
	}

	@Transactional
	public void delete(int id) {
		userdetailsdao.delete(id);
		
	}

	@Transactional
	public void deleteallusers() {
		userdetailsdao.deletealluser();
	}

}
