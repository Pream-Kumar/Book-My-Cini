package com.movie.mapper;

import com.movie.dto.UserDto;
import com.movie.model.User;

public class UserMapper {
	public static UserDto toDTO(User user) {
		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setPassword(user.getPassword());
		userDto.setCreatedAt(user.getCreatedAt());
		userDto.setBookings(user.getBookings().stream().map(BookingMapper::toDto).toList());
		return userDto;
	}
	
	public static User toEntity(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setPassword(userDto.getPassword());
		user.setCreatedAt(userDto.getCreatedAt());
		user.setBookings(userDto.getBookings().stream().map(BookingMapper::toEntity).toList());
		return user;
	}
}
