package com.movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.User;
import com.movie.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/getUser/{id}")
	public Optional<User> getUserById(@PathVariable Long id){
		return userService.getUserById(id);
	}
	
	@GetMapping("/getUser/{name}")
	public User findByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@DeleteMapping("/deleteUserByName/{name}")
	public String deleteUserByName(@PathVariable String name) {
		String response = userService.deleteUserByName(name);
		System.out.println(response);
		return response;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUserById(@PathVariable Long id) {
		String response = userService.deleteUserById(id);
		System.out.println(response);
		return response;
	}
	
}
