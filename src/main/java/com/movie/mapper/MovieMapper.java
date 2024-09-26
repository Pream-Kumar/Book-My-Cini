package com.movie.mapper;

import com.movie.dto.MovieDto;
import com.movie.model.Movie;

public class MovieMapper {
	public static MovieDto toDto(Movie movie) {
		MovieDto movieDto = new MovieDto();
		movieDto.setMovieId(movie.getMovieId());
		movieDto.setTitle(movie.getTitle());
		movieDto.setGenre(movie.getGenre());
		movieDto.setReleaseDate(movie.getReleaseDate());
		movieDto.setDuration(movie.getDuration());
		movieDto.setRating(movie.getRating());
		movieDto.setLanguage(movie.getLanguage());
		movieDto.setDescription(movie.getDescription());
		return movieDto;
	}
	
	public static Movie toEntity(MovieDto movieDto) {
		Movie movie = new Movie();
		movie.setMovieId(movieDto.getMovieId());
		movie.setTitle(movieDto.getTitle());
		movie.setGenre(movieDto.getGenre());
		movie.setReleaseDate(movieDto.getReleaseDate());
		movie.setDuration(movieDto.getDuration());
		movie.setRating(movieDto.getRating());
		movie.setLanguage(movieDto.getLanguage());
		movie.setDescription(movieDto.getDescription());
		return movie;
	}
}