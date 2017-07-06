package com.ccsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.model.User;
import com.ccsp.service.UserService;
import com.ccsp.utils.Response;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    UserService userService;
	
	/**
     * @param bookmarksId
     * This method gets user Bookmarks from database
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(@RequestParam("userName")  String userName,@RequestParam("password") String password) {
    	User user = userService.findById(userName);
    	if (user == null) {
    		return Response.getResponse("User Not Available");
    	}else{
    		if(!password.equals(user.getPassword())){
    			return Response.getResponse("Wrong password");
    		}
    	}
    	return Response.getResponse(user);
    	
    }
}
