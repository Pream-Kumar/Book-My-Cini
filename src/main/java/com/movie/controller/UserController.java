package com.movie.controller;

import com.movie.dto.UserDto;
import com.movie.model.User;
import com.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUser")
	public List<UserDto> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/getUser/{id}")
	public Optional<UserDto> getUserById(@PathVariable Long id){
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

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return userService.verify(user);
	}

}
