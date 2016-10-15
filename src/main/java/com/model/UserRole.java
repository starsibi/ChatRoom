package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="User_id",updatable=false,insertable=false)
	private Role role;
	@ManyToOne
	@JoinColumn(name="User_id",updatable=false,insertable=false)
	private UserDetails userDetails;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	

}
