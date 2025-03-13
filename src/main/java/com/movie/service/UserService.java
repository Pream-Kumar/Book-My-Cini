package com.movie.service;

import java.util.List;
import java.util.Optional;

import com.movie.dto.UserDto;
import com.movie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.User;
import com.movie.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<UserDto> getAllUser(){
		List<User> users = userRepo.findAll();
		return users.stream().map(UserMapper::toDTO).toList();
	}
	
	public Optional<UserDto> getUserById(Long userId){
		userRepo.findById(userId);
		return Optional.of(UserMapper.toDTO(userRepo.findById(userId).get()));
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User findByName(String name) {
		return userRepo.getByName(name);
	}
	
	public String deleteUserByName(String name) {
        if(userRepo.getByName(name) != null) {
        	userRepo.deleteByName(name);
        }
        else
        	return "User not exists";
		return "User"+ name + " is Deleted";
    }
	
	public String deleteUserById(Long userId) {
        if(userRepo.getReferenceById(userId) != null) {
        	userRepo.deleteById(userId);
        }
        else
        	return "User not exists";
        return "User"+ userId + " is Deleted";
	}
	

	public User getUserByName(String name) {
		return userRepo.findByName(name);
	}
}
