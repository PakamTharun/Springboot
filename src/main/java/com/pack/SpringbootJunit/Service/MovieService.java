package com.pack.SpringbootJunit.Service;

import java.util.List;

import com.pack.SpringbootJunit.Entity.Movie;

public interface MovieService {
	public Movie insertMovie(Movie m);
	public List<Movie> getAllMovies();
}
