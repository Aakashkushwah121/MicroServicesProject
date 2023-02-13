package com.user.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Exception.ResourceNotFoundException;
import com.user.entities.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;
	
	@Override
	public User create(User user) {
		String randomId=UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userrepository.findAll();
	}

	@Override
	public User getSingleUser(String userId) {
		return userrepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("id doesn't exit on server"+userId));
	}

	
}