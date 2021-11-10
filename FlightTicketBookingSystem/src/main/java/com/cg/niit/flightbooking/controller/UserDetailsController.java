package com.cg.niit.flightbooking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.niit.flightbooking.entity.UserDetails;
import com.cg.niit.flightbooking.service.UserDetailsService;
@RestController
@RequestMapping("/User")
public class UserDetailsController 
{
	@Autowired
	UserDetailsService userService;
	
	@GetMapping(value="/{userId}/{password}",produces="application/json")
	public HttpStatus loginUser(@PathVariable int userId, @PathVariable String password)
	{
		if(userService.authenticate(userId,password))
			return HttpStatus.OK;
		return HttpStatus.NOT_ACCEPTABLE;
			
	}
	
	 @PostMapping(consumes="application/json")
	 public HttpStatus addUserDetails(@RequestBody UserDetails userDetails)
	 {
		 if(userService.addUserDetails(userDetails))
			 return HttpStatus.CREATED;
		 return HttpStatus.NOT_ACCEPTABLE;			 
	 }
	 
	 @ExceptionHandler(RuntimeException.class)
	 public HttpStatus exceptionHandlerMethod()
	 {
		return HttpStatus.NO_CONTENT;
	 }
	 
}
