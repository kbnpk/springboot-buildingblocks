package com.stacksimply.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimply.restservices.entities.User;
import com.stacksimply.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	
	public User updateUserById(long id,User user) {
		user.setId(id);
		return userRepository.save(user);
		
	}
	
	public void deleteUserById(long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			
		}
		
	}
	
	public User getUserByUserName(String username) {
		
		return userRepository.findByUsername(username);
	}
}


