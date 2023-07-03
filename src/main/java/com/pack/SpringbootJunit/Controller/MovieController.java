package com.pack.SpringbootJunit.Controller;

import java.util.List;

import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.SpringbootJunit.Entity.Movie;
import com.pack.SpringbootJunit.Service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired 
	MovieService movieService;
	
	protected static final org.apache.juli.logging.Log logger=LogFactory.getLog(MovieController.class);
	
	@PostMapping(value="/insertMovie",consumes="application/json")
	public ResponseEntity<Movie> insertMovie(@RequestBody Movie movie) {
		return new ResponseEntity<>(movieService.insertMovie(movie),HttpStatus.OK);
		
	}
	@GetMapping(value="/movie",produces="application/json")

    public List<Movie> getAllMovies(){

                   return movieService.getAllMovies();

    }

}
