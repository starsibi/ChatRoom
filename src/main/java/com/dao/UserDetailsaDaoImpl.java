package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.UserDetails;
@Repository
public class UserDetailsaDaoImpl implements UserDetailsDao {
	@Autowired
	SessionFactory sessionfactory;
	
	//save the userdetails in  the database
	@Override
	public void add(UserDetails userdetails) {
		sessionfactory.getCurrentSession().save(userdetails);
	}

	//update  the userdetails  in the  database
	@Override
	public void update(UserDetails userdetails) {
		sessionfactory.getCurrentSession().update(userdetails);
	}

	//delete the userdetail object in database based on userdetails id
	@Override
	public void delete(int id) {
		sessionfactory.getCurrentSession().delete(getUserDetailsById(id));
	}

	//get the particular userdetails object from the database based on userid
	@Override
	public UserDetails getUserDetailsById(int id) {
		System.out.println("id value="+id);
		return (UserDetails) sessionfactory.getCurrentSession().get(UserDetails.class, id);
		//return sessionfactory.getCurrentSession().createQuery("from UserDetails where user_id='"+id+"'").list();
	}

	//get all the userdetails from the userdetails table 
	@Override
	public List getAllUserDetails() {
	
		return sessionfactory.getCurrentSession().createQuery("from UserDetails").list();
	}

	@Override
	public void deletealluser() {
		sessionfactory.getCurrentSession().clear();
		
	}

}
