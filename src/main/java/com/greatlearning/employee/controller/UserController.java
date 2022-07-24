package com.greatlearning.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		userServiceImpl.addUser(user);
		return user;

	}

}
