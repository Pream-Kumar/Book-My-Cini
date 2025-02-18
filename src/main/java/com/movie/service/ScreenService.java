package com.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.ScreenDto;
import com.movie.mapper.ScreenMapper;
import com.movie.model.Screen;
import com.movie.repository.ScreenRepository;

@Service
public class ScreenService {
	@Autowired
	private ScreenRepository screenRepo;
	@Autowired
	private ScreenMapper screenMapper;
	
	public List<ScreenDto> getAllScreens(){
	    return screenRepo.findAll()
	                     .stream()
	                     .map(screenMapper::toDto)
	                     .collect(Collectors.toList());
	}
	
	public Optional<ScreenDto> getScreenById(Long screenId){
	    return screenRepo.findById(screenId).map(screenMapper::toDto);
	}
	
	public Screen addScreen(Screen screen) {
		return screenRepo.save(screen);
	}
	
	public String deleteScreen(Long screenId) {
	    if(screenRepo.existsById(screenId)) {
	        screenRepo.deleteById(screenId);
	        return "Screen deleted successfully";
	    } else {
	        return "Screen does not exist";
	    }
	}

	
}
