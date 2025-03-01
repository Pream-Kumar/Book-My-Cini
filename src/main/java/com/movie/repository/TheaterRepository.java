package com.movie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
	Optional<Theater> findByName(String name);

	@Query("SELECT t FROM Theater t JOIN t.theatersMovies m WHERE m.title = :movieName")
	Optional<Theater> findBytheatersMovies(@Param("movieName") String movieName);

	@Query("SELECT t FROM Theater t WHERE t.location = :location")
	Optional<List<Theater>> findByLocation(@Param("location") String location);

}
