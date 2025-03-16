package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	void deleteByName(String name);

	User getByName(String name);

	User findByName(String name);

	Optional<User> findByEmail(String email);
}
