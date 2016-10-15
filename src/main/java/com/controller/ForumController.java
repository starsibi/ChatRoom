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

import com.model.Forum;
import com.model.UserDetails;
import com.service.ForumService;

@Controller
public class ForumController {
	
	@Autowired
	ForumService forumservice;

	/*---------------create Forum---------------------------*/
	 @RequestMapping(value = "/forum/add", method = RequestMethod.POST)
	    public ResponseEntity<Void> createForum(@RequestBody Forum  forum,    UriComponentsBuilder ucBuilder) {
	        forumservice.add(forum);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/forum/{id}").buildAndExpand(forum.getForum_id()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	 //--------------------Retrive a Forum by id----------------------------------------------------
	 @RequestMapping(value = "/forum/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Forum> getUser(@PathVariable("id") int id) {
	        System.out.println("Fetching User with id " + id);
	        Forum forumdetail=(Forum) forumservice.getForumById(id);
	        
	        if (forumdetail == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Forum>(forumdetail, HttpStatus.OK);
	    }
	 
	 
	 //-----------------------------Retrive all the Forum-------------------------------------------
	 @RequestMapping(value = "/forum/", method = RequestMethod.GET)
	    public ResponseEntity<List<Forum>> listAllUsers() {
	        List<Forum> forum = forumservice.getAllForum();
	        if(forum.isEmpty()){
	            return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Forum>>(forum, HttpStatus.OK);
	    }
	  
	 
	//-----------------------------------Delete Forum by id-----------------------------------------------
		 @RequestMapping(value = "/forum/{id}", method = RequestMethod.DELETE)
		    public ResponseEntity<Forum> deleteUser(@PathVariable("id") int id) {
		        System.out.println("Fetching & Deleting User with id " + id);
		  
		        Forum forum = (Forum) forumservice.getForumById(id);
		        if (forum == null) {
		            System.out.println("Unable to delete. User with id " + id + " not found");
		            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		        }
		  
		        forumservice.delete(id);
		        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
		    }
		 
		//-----------------------------------update user by id----------------------------------------------------------------------------------
		 @RequestMapping(value = "/forum/{id}", method = RequestMethod.PUT)
		    public ResponseEntity<Forum> updateUser(@PathVariable("id") int id, @RequestBody Forum forum) {
		        System.out.println("Updating User " + id);
		          
		        Forum forumdetails=(Forum) forumservice.getForumById(id);
		        
		          
		        if (forumdetails==null) {
		            System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		        }
		  
		        forumdetails.setForum_id(forum.getForum_id());
		        forumdetails.setForum_name(forumdetails.getForum_name());
		        forumdetails.setComment_id(forumdetails.getComment_id());
		        forumdetails.setForumApproved(forumdetails.getForumApproved());
		        forumdetails.setPosted_date(forumdetails.getPosted_date());
		        forumdetails.setPosted_time(forumdetails.getPosted_time());
		        
		        forumservice.update(forumdetails);
		        return new ResponseEntity<Forum>(forumdetails, HttpStatus.OK);
		    }
		 

		//------------------- Delete All Users --------------------------------------------------------
	     
		    @RequestMapping(value = "/forum/", method = RequestMethod.DELETE)
		    public ResponseEntity<Forum> deleteAllUsers() {
		        System.out.println("Deleting All Users");
		        forumservice.deleteAllForum();
		        //userdetailservice.deleteallusers();
		        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
		    }
}
