package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;


import com.model.UserDetails;
import com.service.UserDetailsService;

@Controller
public class UserController {
	@Autowired
	UserDetailsService userdetailservice;
	
	/*---------------create user---------------------------*/
	 @RequestMapping(value = "/users/add", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody UserDetails userdetails,    UriComponentsBuilder ucBuilder) {
	        userdetailservice.add(userdetails);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(userdetails.getUser_id()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	
	 //--------------------Retrive a User by id----------------------------------------------------
	 @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<UserDetails> getUser(@PathVariable("id") int id) {
	        System.out.println("Fetching User with id " + id);
	        UserDetails user = userdetailservice.getUserDetailsById(id);
	        if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	    }
	  
	 
	 //-----------------------------Retrive all the user-------------------------------------------
	 @RequestMapping(value = "/users/", method = RequestMethod.GET)
	    public ResponseEntity<List<UserDetails>> listAllUsers() {
	        List<UserDetails> users = userdetailservice.getAllUserDetails();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<UserDetails>>(users, HttpStatus.OK);
	    }
	  
	 //-----------------------------------Delete User by id-----------------------------------------------
	 @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<UserDetails> deleteUser(@PathVariable("id") int id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	  
	        UserDetails user = userdetailservice.getUserDetailsById(id);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	  
	        userdetailservice.delete(id);
	        return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	    }
	  
	 //-----------------------------------update user by id----------------------------------------------------------------------------------
	 @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<UserDetails> updateUser(@PathVariable("id") int id, @RequestBody UserDetails userdetails) {
	        System.out.println("Updating User " + id);
	          
	        UserDetails currentUser = userdetailservice.getUserDetailsById(id);
	          
	        if (currentUser==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	  
	     //   currentUser.setUsername(user.getUsername());
	      currentUser.setAddress(userdetails.getAddress());
	      currentUser.setEmail(userdetails.getEmail());
	      currentUser.setMobilenumber(userdetails.getMobilenumber());
	      currentUser.setName(userdetails.getName());
	      currentUser.setPassword(userdetails.getPassword());
	      currentUser.setStatus(userdetails.isStatus());
	      currentUser.setUser_id(userdetails.getUser_id());
	          
	        userdetailservice.update(currentUser);
	        return new ResponseEntity<UserDetails>(currentUser, HttpStatus.OK);
	    }
	 
	//------------------- Delete All Users --------------------------------------------------------
     
	    @RequestMapping(value = "/users/", method = RequestMethod.DELETE)
	    public ResponseEntity<UserDetails> deleteAllUsers() {
	        System.out.println("Deleting All Users");
	  
	        userdetailservice.deleteallusers();
	        return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	    }
	  
}
