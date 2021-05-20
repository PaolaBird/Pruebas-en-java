package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "El diario de noa", 160, Genre.ROMANCE, "Nicholas spark"),
                        new Movie(2, "Querido Jhon", 120, Genre.ROMANCE, "Nicholas spark"),
                        new Movie(3, "Media noche en Paris", 120, Genre.ROMANCE, "Woody Allen"),
                        new Movie(4, "Naked", 100, Genre.COMEDY, "Director 1"),
                        new Movie(5, "Rapido y furioso", 170, Genre.ACTION, "Director 2"),
                        new Movie(6, "Bajo la misma estrella", 130, Genre.DRAMA, "Nicholas spark"),
                        new Movie(7, "Super inteligencia", 130, Genre.ROMANCE, "Director 4"),
                        new Movie(8, "Superman", 130, Genre.ACTION, "Director 5")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMovieByGenre(Genre.ROMANCE);
        assertThat(getMoviesIds(movies), is(Arrays.asList(1, 2, 3, 7)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMovieByLength(120);
        assertThat(getMoviesIds(movies), is(Arrays.asList(2, 3, 4)));
    }

    @Test
    public void return_movies_by_name() {
        Collection<Movie> movies = movieService.findByName("super");
        assertThat(getMoviesIds(movies), is(Arrays.asList(7, 8)));
    }

    @Test
    public void return_movies_by_director() {
        Collection<Movie> movies = movieService.findByDirector("Nicholas spark");
        assertThat(getMoviesIds(movies), is(Arrays.asList(1, 2, 6)));
    }

    @Test
    public void return_movie_by_template() {
        String name = null;
        int minutes = 160;
        Genre genre = Genre.ACTION;
        Movie template = new Movie(name, minutes, genre, "Director4");
        Collection<Movie> movies =
                movieService.findMoviesByTemplate(template);
        assertThat(getMoviesIds(movies), is(Arrays.asList(1, 5, 8)));
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}