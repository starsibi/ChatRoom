package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.model.Blog;
import com.model.UserDetails;
import com.service.BlogService;

@RestController
public class BlogController {
	
	@Autowired
	BlogService blogservice;
	
	/*---------------create Blog---------------------------*/
	 @RequestMapping(value = "/blogs/add", method = RequestMethod.POST)
	    public ResponseEntity<Void> createBlog(@RequestBody Blog blog,    UriComponentsBuilder ucBuilder) {
	       blogservice.add(blog);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/blogs/{id}").buildAndExpand(blog.getBlog_id()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 

	 //--------------------Retrive a Blog by id----------------------------------------------------
	 @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
	       Blog blogdet=(Blog) blogservice.getBlogById(id);
	        if (blogdet== null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Blog>(blogdet, HttpStatus.OK);
	    }
	 
	//-----------------------------Retrive all the Blogs-------------------------------------------
		 @RequestMapping(value = "/blogs/", method = RequestMethod.GET)
		    public ResponseEntity<List<Blog>> listAllBlogs() {
		        List<Blog> blogdet = blogservice.getAllBlog();
		        if(blogdet.isEmpty()){
		            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		        }
		        return new ResponseEntity<List<Blog>>(blogdet, HttpStatus.OK);
		    }
		 
		 
		 //-----------------------------------Delete Blog by id-----------------------------------------------
		 @RequestMapping(value = "/blogs/{id}", method = RequestMethod.DELETE)
		    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id) 
		 { 
		        Blog blogdet =(Blog) blogservice.getBlogById(id);
		        if (blogdet == null) {
		            System.out.println("Unable to delete. User with id " + id + " not found");
		            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		        }
		  
		       blogservice.delete(id);
		        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
		    }
		  
		 //-----------------------------------update blog by id----------------------------------------------------------------------------------
		 @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
		    public ResponseEntity<Blog> updateUser(@PathVariable("id") int id, @RequestBody Blog blog) {
		        System.out.println("Updating User " + id);
		          
		        Blog currentblog = (Blog) blogservice.getBlogById(id);
		          
		        if (currentblog==null) {
		            System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		        }
		  
		        currentblog.setBlog_id(blog.getBlog_id());
		        currentblog.setBlog_name(blog.getBlog_name());
		        currentblog.setBlog_approved(blog.isBlog_approved());
		        currentblog.setImg_name(blog.getImg_name());
		        currentblog.setPosted_date(blog.getPosted_date());
		        currentblog.setPosted_time(blog.getPosted_time());
		        blogservice.update(currentblog);
		          
		        
		        return new ResponseEntity<Blog>(currentblog, HttpStatus.OK);
		    }
		 
		//------------------- Delete All Blogs--------------------------------------------------------
	     
		    @RequestMapping(value = "/blogs/", method = RequestMethod.DELETE)
		    public ResponseEntity<Blog> deleteAllUsers() {
		        System.out.println("Deleting All Users");
		  
		      blogservice.deleteAllBlog();
		        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
		    }
		  
}
