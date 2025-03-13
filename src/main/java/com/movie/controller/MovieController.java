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
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.service.MovieService;


@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/getAllMovies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/getMovieById/{id}")
	public Optional<Movie> getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping("/getMovieByName/{title}")
	public Optional<Movie> getMovieByName(@PathVariable String title) {
		return movieService.getMovieByName(title);
	}
	
	@PostMapping("/addNewMovies")
	public Movie addNewMovies(@RequestBody Movie movie) {
		return movieService.addNewMovies(movie);
	}
	
	@DeleteMapping("/deleteMovie/{id}")
	public String deleteMovieById(@PathVariable Long id) {
		String response = movieService.deleteMovie(id);
		System.out.println(response);
		return response;
	}

}
