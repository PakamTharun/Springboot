package com.pack.SpringbootJunit.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Movie {
	@Id
	 public Integer id;
     public String name;
     public String language;
     public String type;
     public Integer rating;
	public Movie(Integer id, String name, String language, String type, Integer rating) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.type = type;
		this.rating = rating;
	}
     
     
	
}
