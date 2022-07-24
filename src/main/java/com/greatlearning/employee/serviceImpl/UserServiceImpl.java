package com.greatlearning.employee.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.repository.UserRepository;
import com.greatlearning.employee.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.saveAndFlush(user);

	}

}
