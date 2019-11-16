package com.stacksimply.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimply.restservices.entities.User;
import com.stacksimply.restservices.exceptions.UserExistsException;
import com.stacksimply.restservices.exceptions.UserNotFoundException;
import com.stacksimply.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) throws UserExistsException{
		
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if(existingUser != null) {
			throw new UserExistsException("User already exists in the repository");
		}
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found in user repository");
		}
		return user;
	}
	
	
	public User updateUserById(long id,User user) throws UserNotFoundException{
		
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found in user repository,provide the correct user id");
		}
		
		user.setId(id);
		return userRepository.save(user);
		
	}
	
	public void deleteUserById(long id) {
Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in the user repository");
		}
		
			userRepository.deleteById(id);
			
		
		
	}
	
	public User getUserByUserName(String username) {
		
		return userRepository.findByUsername(username);
	}
}


