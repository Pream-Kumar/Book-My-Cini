package com.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
	Optional<Theater> findByName(String name);
}
