package com.stacksimply.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimply.restservices.entities.Order;
import com.stacksimply.restservices.entities.User;
import com.stacksimply.restservices.exceptions.UserNotFoundException;
import com.stacksimply.restservices.repositories.OrderRepository;
import com.stacksimply.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value="/hateoas/users")
@Validated
public class OrderHateoasController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException{
		
		Optional<User> user = userRepository.findById(userid);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		return user.get().getOrder();
		
	}

}
