package com.pyt.handbook.controller;

import java.net.http.HttpResponse;

import static com.pyt.handbook.constant.AppConstants.GSON;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.handbook.request.UserSignupRequest;
import com.pyt.handbook.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserService userService;
	
	@PostMapping("signup")
	public String signup(@RequestBody UserSignupRequest userSignupRequest, HttpServletResponse response) {
		try {
			userService.saveUser(userSignupRequest);
		}catch (Exception e) {
			logger.error("Error creating user", e);
			return "failed";
		}
		
		return "success";
	}
	
	
	@PostMapping("login")
	public String login(@RequestBody UserSignupRequest userSignupRequest, HttpServletResponse response) {
		try {
			userService.saveUser(userSignupRequest);
		}catch (Exception e) {
			logger.error("Error creating user", e);
			return "failed";
		}
		
		return "success";
	}
	
}
