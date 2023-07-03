package com.pack.SpringbootJunit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.SpringbootJunit.Entity.Movie;
import com.pack.SpringbootJunit.Repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired

	MovieRepository movieRepo;

	@Override

	public Movie insertMovie(Movie m) {

		return movieRepo.save(m);

	}

	

	@Override
	public List<Movie> getAllMovies() {
		
		return movieRepo.findAll();
	}

}
