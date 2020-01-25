package com.pyt.handbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyt.handbook.dao.UserDAO;
import com.pyt.handbook.modal.User;
import com.pyt.handbook.request.UserSignupRequest;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	public User saveUser(UserSignupRequest request) {
		User user = new User();
		user.setEmpId(request.getEmpId());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		return userDAO.saveUser(user);
	}
}
