package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findByName(String name) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name)).collect(Collectors.toList());
    }

    public Collection<Movie> findByDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector() == director).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().equalsIgnoreCase(template.getName()) ||
                        movie.getMinutes() == template.getMinutes() ||
                        movie.getGenre() == template.getGenre()).collect(Collectors.toList());
    }

}
