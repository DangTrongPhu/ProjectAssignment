package com.mkyong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.model.Candidate;
import com.mkyong.model.User;
import com.mkyong.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	public User loginUser(String email,String pass)
	{
		return userRepository.loginUser(email, pass);
	}
	public User save(User user) {
		return userRepository.save(user);
	}
}
