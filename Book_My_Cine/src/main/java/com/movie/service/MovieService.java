package com.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;

	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	public Optional<Movie> getMovieById(Long id) {
		return movieRepo.findById(id);
	}
	
	public Optional<Movie> getMovieByName(String title) {
		return movieRepo.findByTitle(title);
	}
	
	public Movie addNewMovies(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public String deleteMovie(Long movieId) {
		if(movieRepo.getReferenceById(movieId) != null) {
        	movieRepo.deleteById(movieId);
        }
		else {
			return "Movie does not exist";
		}
		return "Movie deleted successfully";
//		movieRepo.deleteById(movieId);
	}
	
}
