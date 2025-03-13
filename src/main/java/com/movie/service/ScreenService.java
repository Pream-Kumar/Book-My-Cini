package com.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Screen;
import com.movie.repository.ScreenRepository;

@Service
public class ScreenService {
	@Autowired
	private ScreenRepository screenRepo;
	
	public List<Screen> getAllScreens(){
		return screenRepo.findAll();
	}
	
	public Optional<Screen> getScreenById(Long screenId){
		return screenRepo.findById(screenId);
	}
	
	public Screen addScreen(Screen screen) {
		return screenRepo.save(screen);
	}
	
	public String deleteScreen(Long screenId) {
		if(screenRepo.getReferenceById(screenId) != null) {
        	screenRepo.deleteById(screenId);
        }
		else {
			return "Screen does not exist";
		}
		return "Screen deleted successfully";
	}
	
}
