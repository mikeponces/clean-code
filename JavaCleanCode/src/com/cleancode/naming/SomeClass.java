package com.cleancode.naming;

import java.util.List;

@SuppressWarnings("unused")
public class SomeClass {
	
	// scattered methods
	public static class MovieUtils {
	    public static double calculateAverageRating(List<Movie> movies) { return 0; }
	    public static List<Movie> filterByGenre(List<Movie> movies, String genre) { return null; }
	    public static List<Movie> sortByReleaseDate(List<Movie> movies) { return null; }
	}

	// composite object
	public class MovieCollection {
		private List<Movie> movies;
	    
	    public MovieCollection(List<Movie> movies) {
	        this.movies = movies;
	    }
	    
	    public double getAverageRating() { return 0; }
	    public MovieCollection filterByGenre(String genre) { return this; }
	    public MovieCollection sortByReleaseDate() { return this; }
	}
	
	class Movie {
		
	}
}

