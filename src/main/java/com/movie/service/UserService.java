package com.movie.service;

import com.movie.dto.UserDto;
import com.movie.mapper.UserMapper;
import com.movie.model.User;
import com.movie.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

	@Autowired
	private JWTService jwtService;
	@Autowired
	AuthenticationManager authManager;
	@Autowired
	private UserRepository userRepo;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


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

	public User register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return user;
	}

	public String verify(User user) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getName());
		} else {
			return "fail";
		}
	}
}
