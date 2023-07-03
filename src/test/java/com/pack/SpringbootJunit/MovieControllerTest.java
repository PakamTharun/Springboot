package com.pack.SpringbootJunit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.SpringbootJunit.Entity.Movie;
import com.pack.SpringbootJunit.Repository.MovieRepository;
import com.pack.SpringbootJunit.Service.MovieServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest
public class MovieControllerTest {

	
	@Autowired

    MockMvc mockMvc;

   

    @MockBean

    MovieServiceImpl movieImpl;

   

    @MockBean

    MovieRepository movieRepo;

   

    private static ObjectMapper mapper=new ObjectMapper();

   

    @Test

    public void testInsertMovie() throws Exception {

                   Movie m=new Movie(104,"Tamil","Pizza","thriller",4);

                   Mockito.when(movieRepo.save(m)).thenReturn(m);

    Mockito.when(movieImpl.insertMovie(ArgumentMatchers.any())).thenReturn(m);

                  

                   String movieJson=mapper.writeValueAsString(m); //convert movie to String

                  

                   MvcResult result=mockMvc.perform(post("/movie/insertMovie")

                                               .contentType(MediaType.APPLICATION_JSON)

                                                .characterEncoding("utf-8").content(movieJson).accept(MediaType.APPLICATION_JSON)).andReturn();

                   String res=result.getResponse().getContentAsString(); //convert response to string

                  

                   Movie mov=new ObjectMapper().readValue(res, Movie.class); //convert response to movie object

                   assertEquals((Integer)104,mov.id);

    }

   

    @Test

    public void testGetAllMovies() throws Exception {

                   List<Movie> l=new ArrayList<>();

                   l.add(new Movie(105,"hindi","Dangal","sports",4));

                   l.add(new Movie(106,"hindi","Dhoom","thriller",3));

                  

                   Mockito.when(movieImpl.getAllMovies()).thenReturn(l);

                   MvcResult result=mockMvc.perform(get("/movie/movies")).andReturn();

                   String res=result.getResponse().getContentAsString();

                   List<Movie> mlist=new ArrayList<>();

                   mlist=Arrays.asList(mapper.readValue(res, Movie[].class));

                   assertEquals(l.size(),mlist.size());

    }

   
}
