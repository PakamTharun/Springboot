package com.pack.SpringbootJunit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.SpringbootJunit.Entity.Movie;

public interface MovieRepository  extends JpaRepository<Movie, Integer>{

	

}
